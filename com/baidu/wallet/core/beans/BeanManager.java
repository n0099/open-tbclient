package com.baidu.wallet.core.beans;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
/* loaded from: classes5.dex */
public final class BeanManager {

    /* renamed from: a  reason: collision with root package name */
    public final HashMap<String, ArrayList<BaseBean<?>>> f23915a;

    /* loaded from: classes5.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public static BeanManager f23916a = new BeanManager();
    }

    public static BeanManager getInstance() {
        return a.f23916a;
    }

    public synchronized void addBean(String str, BaseBean<?> baseBean) {
        ArrayList<BaseBean<?>> arrayList = this.f23915a.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.f23915a.put(str, arrayList);
        }
        arrayList.add(baseBean);
    }

    public synchronized void removeAllBeans(String str) {
        ArrayList<BaseBean<?>> arrayList = this.f23915a.get(str);
        if (arrayList != null) {
            Iterator<BaseBean<?>> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().destroyBean();
            }
            this.f23915a.remove(str);
        }
    }

    public synchronized void removeBean(BaseBean<?> baseBean) {
        for (String str : this.f23915a.keySet()) {
            ArrayList<BaseBean<?>> arrayList = this.f23915a.get(str);
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
        this.f23915a = new HashMap<>();
    }
}
