package com.baidu.tieba.util;

import android.widget.ListAdapter;
import android.widget.ListView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class u {
    public static void a(ListView listView, a aVar, int i, int i2) {
        boolean z;
        int i3;
        LinkedList<String> m;
        LinkedList<String> l;
        if (listView != null && aVar != null) {
            aVar.a();
            int firstVisiblePosition = listView.getFirstVisiblePosition();
            int lastVisiblePosition = listView.getLastVisiblePosition();
            ListAdapter adapter = listView.getAdapter();
            if (adapter != null) {
                v vVar = new v(listView);
                w wVar = new w(listView);
                int i4 = 0;
                try {
                    UtilHelper.NetworkStateInfo i5 = UtilHelper.i(TiebaApplication.g());
                    if (i5 == UtilHelper.NetworkStateInfo.WIFI || i5 == UtilHelper.NetworkStateInfo.ThreeG) {
                        z = true;
                    } else {
                        z = false;
                    }
                    int i6 = firstVisiblePosition;
                    int i7 = 0;
                    while (i6 < adapter.getCount()) {
                        if (i6 <= lastVisiblePosition || z) {
                            if (adapter.getItem(i6) instanceof x) {
                                x xVar = (x) adapter.getItem(i6);
                                if (i == 0 && i7 < 13 && (l = xVar.l()) != null) {
                                    Iterator<String> it = l.iterator();
                                    int i8 = i7;
                                    while (it.hasNext()) {
                                        i8++;
                                        aVar.a(it.next(), vVar);
                                    }
                                    i7 = i8;
                                }
                                if (i4 < 30 && (m = xVar.m()) != null) {
                                    Iterator<String> it2 = m.iterator();
                                    while (it2.hasNext()) {
                                        String next = it2.next();
                                        i4++;
                                        if (i2 == 0) {
                                            aVar.d(next, wVar);
                                        } else if (i2 == 1) {
                                            aVar.b(next, wVar);
                                        }
                                    }
                                }
                                i3 = i4;
                                if (z && i7 >= 13 && i3 >= 30) {
                                    return;
                                }
                            } else {
                                i3 = i4;
                            }
                            i6++;
                            i4 = i3;
                        } else {
                            return;
                        }
                    }
                } catch (Exception e) {
                    av.b("LoadImageHelper", "loadListView", e.toString());
                }
            }
        }
    }
}
