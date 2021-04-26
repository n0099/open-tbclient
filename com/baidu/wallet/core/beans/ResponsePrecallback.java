package com.baidu.wallet.core.beans;

import android.text.TextUtils;
import com.baidu.apollon.beans.IBeanResponseCallback;
import com.baidu.apollon.eventbus.EventBus;
import com.baidu.wallet.core.NoProguard;
/* loaded from: classes5.dex */
public abstract class ResponsePrecallback implements IBeanResponseCallback, NoProguard {

    /* loaded from: classes5.dex */
    public enum ResponseType {
        OkJson,
        OkString,
        Fail
    }

    public static String getNotifyKeyName(Class cls, ResponseType responseType) {
        if (cls != null) {
            if (responseType == null) {
                responseType = ResponseType.OkJson;
            }
            return cls.getSimpleName() + responseType.name();
        }
        throw new NullPointerException("callbackClz null");
    }

    public abstract void handleResponse(int i2, Object obj, String str);

    @Override // com.baidu.apollon.beans.IBeanResponseCallback
    public void onBeanExecFailure(int i2, int i3, String str) {
        removeRequest();
        BeanErrorContent beanErrorContent = new BeanErrorContent(i2, i3, str, null);
        EventBus eventBus = EventBus.getInstance();
        eventBus.getClass();
        eventBus.post(new EventBus.Event(getNotifyKeyName(getClass(), ResponseType.Fail), beanErrorContent));
    }

    @Override // com.baidu.apollon.beans.IBeanResponseCallback
    public void onBeanExecSuccess(int i2, Object obj, String str) {
        if (obj != null) {
            EventBus eventBus = EventBus.getInstance();
            eventBus.getClass();
            eventBus.post(new EventBus.Event(getNotifyKeyName(getClass(), ResponseType.OkJson), obj));
        } else if (TextUtils.isEmpty(str)) {
            EventBus eventBus2 = EventBus.getInstance();
            eventBus2.getClass();
            eventBus2.post(new EventBus.Event(getNotifyKeyName(getClass(), ResponseType.OkString), str));
        }
        removeRequest();
        handleResponse(i2, obj, str);
    }

    public abstract void removeRequest();
}
