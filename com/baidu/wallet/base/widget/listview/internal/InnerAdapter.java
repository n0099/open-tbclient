package com.baidu.wallet.base.widget.listview.internal;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.apollon.utils.ResUtils;
import com.baidu.wallet.base.widget.listview.BaseListAdapter;
import com.baidu.wallet.base.widget.listview.ViewMappingUtil;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class InnerAdapter<T> extends BaseAdapter {

    /* renamed from: a  reason: collision with root package name */
    public List<Class<?>> f23761a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public Context f23762b;

    /* renamed from: c  reason: collision with root package name */
    public BaseListAdapter<T> f23763c;

    public InnerAdapter(Context context, BaseListAdapter<T> baseListAdapter) {
        this.f23762b = context;
        this.f23763c = baseListAdapter;
    }

    private void a(int i, T t, BaseListAdapter.BaseViewHolder baseViewHolder, BaseListAdapter<T> baseListAdapter) {
        baseViewHolder.setView(t, i, this.f23762b, baseListAdapter);
    }

    public int getBindItemViewResId(int i) {
        if (BindLayoutMapping.getLayoutId(getViewBundles().get(this.f23763c.useItemTrueType() ? this.f23763c.getItemTrueType(i) : this.f23763c.getItemViewType(i))).equals("NOT_USE_XML")) {
            return -1;
        }
        return ResUtils.layout(this.f23762b, BindLayoutMapping.getLayoutId(getViewBundles().get(this.f23763c.useItemTrueType() ? this.f23763c.getItemTrueType(i) : this.f23763c.getItemViewType(i))));
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return 0;
    }

    @Override // android.widget.Adapter
    public T getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        BaseListAdapter.BaseViewHolder baseViewHolder;
        if (view == null) {
            BaseListAdapter.BaseViewHolder onCreateViewHolder = onCreateViewHolder(i, getViewBundles());
            baseViewHolder = onCreateViewHolder;
            view = a(i, onCreateViewHolder);
        } else {
            baseViewHolder = (BaseListAdapter.BaseViewHolder) view.getTag();
        }
        if (view != null && view.getTag() != null) {
            a(i, this.f23763c.getItem(i), baseViewHolder, this.f23763c);
            return view;
        }
        throw new NullPointerException(" creatview fails");
    }

    public List<Class<?>> getViewBundles() {
        return a(this.f23761a);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 0;
    }

    public void handleViewHolder(BaseListAdapter.BaseViewHolder baseViewHolder, T... tArr) {
    }

    public BaseListAdapter.BaseViewHolder onCreateViewHolder(int i, List<Class<?>> list) {
        return (BaseListAdapter.BaseViewHolder) a(list.get(this.f23763c.useItemTrueType() ? this.f23763c.getItemTrueType(i) : this.f23763c.getItemViewType(i)));
    }

    /* JADX DEBUG: Multi-variable search result rejected for r2v0, resolved type: com.baidu.wallet.base.widget.listview.internal.InnerAdapter<T> */
    /* JADX WARN: Multi-variable type inference failed */
    private View a(int i, BaseListAdapter.BaseViewHolder baseViewHolder) {
        View inflate;
        if (getBindItemViewResId(i) == -1) {
            inflate = baseViewHolder.createView(this.f23762b);
        } else {
            inflate = View.inflate(this.f23762b, getBindItemViewResId(i), null);
            ViewMappingUtil.mapView(baseViewHolder, inflate);
        }
        handleViewHolder(baseViewHolder, new Object[0]);
        inflate.setTag(baseViewHolder);
        return inflate;
    }

    public static <T> T a(Class<T> cls) {
        try {
            Constructor<T> declaredConstructor = cls.getDeclaredConstructor(new Class[0]);
            declaredConstructor.setAccessible(true);
            return declaredConstructor.newInstance(new Object[0]);
        } catch (IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | InvocationTargetException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    private List<Class<?>> a(List<Class<?>> list) {
        if (list.size() <= 0) {
            this.f23763c.onBindViewHolder(list);
        }
        return list;
    }
}
