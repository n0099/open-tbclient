package com.baidu.tieba.screenlocknotify;

import android.text.TextUtils;
import android.widget.TextView;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tieba.r;
import com.baidu.tieba.screenlocknotify.loadmore.ScreenLockLoadMoreHttpResponseMessage;
import com.baidu.tieba.screenlocknotify.loadmore.ScreenLockLoadMoreSocketResponseMessage;
import java.util.ArrayList;
/* loaded from: classes.dex */
class e extends com.baidu.adp.framework.listener.a {
    final /* synthetic */ ScreenLockActivity this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(ScreenLockActivity screenLockActivity, int i, int i2) {
        super(i, i2);
        this.this$0 = screenLockActivity;
    }

    @Override // com.baidu.adp.framework.listener.a
    public void onMessage(ResponsedMessage responsedMessage) {
        com.baidu.tieba.screenlocknotify.loadmore.a data;
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        this.this$0.mIsLoading = false;
        if (responsedMessage != null) {
            if ((responsedMessage instanceof ScreenLockLoadMoreHttpResponseMessage) || (responsedMessage instanceof ScreenLockLoadMoreSocketResponseMessage)) {
                if (responsedMessage.getError() != 0) {
                    this.this$0.showToast(TextUtils.isEmpty(responsedMessage.getErrorString()) ? this.this$0.getResources().getString(r.j.screen_notify_load_error) : responsedMessage.getErrorString());
                    textView3 = this.this$0.eQt;
                    if (textView3 != null) {
                        textView4 = this.this$0.eQt;
                        textView4.setText(this.this$0.getResources().getString(r.j.data_load_error));
                        textView5 = this.this$0.eQt;
                        textView5.setEnabled(true);
                        return;
                    }
                    return;
                }
                if (responsedMessage instanceof ScreenLockLoadMoreHttpResponseMessage) {
                    data = ((ScreenLockLoadMoreHttpResponseMessage) responsedMessage).getData();
                } else {
                    data = responsedMessage instanceof ScreenLockLoadMoreSocketResponseMessage ? ((ScreenLockLoadMoreSocketResponseMessage) responsedMessage).getData() : null;
                }
                if (data != null) {
                    ArrayList<s> aYU = data.aYU();
                    if (this.this$0.eQq != null) {
                        this.this$0.eQq.cQ(aYU);
                    }
                    if (!data.isHasMore()) {
                        this.this$0.eQq.setHasMore(false);
                        textView = this.this$0.eQt;
                        if (textView != null) {
                            DynamicHeightListView dynamicHeightListView = this.this$0.eQp;
                            textView2 = this.this$0.eQt;
                            dynamicHeightListView.removeFooterView(textView2);
                            this.this$0.eQt = null;
                        }
                    }
                }
            }
        }
    }
}
