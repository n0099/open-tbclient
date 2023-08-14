package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.widget.ListView.TypeAdapter;
import java.util.List;
/* loaded from: classes7.dex */
public interface m26 extends p26<r26> {
    void a(int i);

    List<Integer> d();

    void e(List<l26> list, String str, String str2, String str3, String str4, boolean z, int i);

    TypeAdapter.ViewHolder g(ViewGroup viewGroup, Object obj);

    void i(List<l26> list, int i);

    void k(List<Object> list);

    View m(int i, View view2, ViewGroup viewGroup, Object obj);

    void n(int i, ViewGroup viewGroup, TypeAdapter.ViewHolder viewHolder, Object obj);

    void o(List<l26> list, List<l26> list2, boolean z, int i);

    void p(String str);
}
