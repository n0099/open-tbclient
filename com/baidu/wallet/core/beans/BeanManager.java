package com.baidu.wallet.core.beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes5.dex */
public final class BeanManager {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap<String, ArrayList<BaseBean<?>>> f24232a;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static BeanManager f24233a = new BeanManager();
    }

    public static BeanManager getInstance() {
        return a.f24233a;
    }

    public synchronized void addBean(String str, BaseBean<?> baseBean) {
        ArrayList<BaseBean<?>> arrayList = this.f24232a.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.f24232a.put(str, arrayList);
        }
        arrayList.add(baseBean);
    }

    public synchronized void removeAllBeans(String str) {
        ArrayList<BaseBean<?>> arrayList = this.f24232a.get(str);
        if (arrayList != null) {
            Iterator<BaseBean<?>> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().destroyBean();
            }
            this.f24232a.remove(str);
        }
    }

    public synchronized void removeBean(BaseBean<?> baseBean) {
        for (String str : this.f24232a.keySet()) {
            ArrayList<BaseBean<?>> arrayList = this.f24232a.get(str);
            if (arrayList != null && arrayList.size() > 0) {
                Iterator<BaseBean<?>> it = arrayList.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (baseBean == it.next()) {
                            arrayList.remove(baseBean);
                            baseBean.destroyBean();
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
    }

    public BeanManager() {
        this.f24232a = new HashMap<>();
    }
}
