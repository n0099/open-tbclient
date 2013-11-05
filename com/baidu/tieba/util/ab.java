package com.baidu.tieba.util;

import android.widget.ListAdapter;
import android.widget.ListView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class ab {
    public static void a(ListView listView, a aVar, int i, int i2) {
        boolean z;
        int i3;
        LinkedList<String> photoUrl;
        LinkedList<String> imageUrl;
        if (listView != null && aVar != null) {
            aVar.a();
            int firstVisiblePosition = listView.getFirstVisiblePosition();
            int lastVisiblePosition = listView.getLastVisiblePosition();
            ListAdapter adapter = listView.getAdapter();
            if (adapter != null) {
                ac acVar = new ac(listView);
                ad adVar = new ad(listView);
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
                            if (adapter.getItem(i6) instanceof ae) {
                                ae aeVar = (ae) adapter.getItem(i6);
                                if (i == 0 && i7 < 13 && (imageUrl = aeVar.getImageUrl()) != null) {
                                    Iterator<String> it = imageUrl.iterator();
                                    int i8 = i7;
                                    while (it.hasNext()) {
                                        i8++;
                                        aVar.a(it.next(), acVar);
                                    }
                                    i7 = i8;
                                }
                                if (i4 < 30 && (photoUrl = aeVar.getPhotoUrl()) != null) {
                                    Iterator<String> it2 = photoUrl.iterator();
                                    while (it2.hasNext()) {
                                        String next = it2.next();
                                        i4++;
                                        if (i2 == 0) {
                                            aVar.d(next, adVar);
                                        } else if (i2 == 1) {
                                            com.baidu.adp.lib.h.d.d("loadimg:" + next);
                                            aVar.b(next, adVar);
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
                    be.b("LoadImageHelper", "loadListView", e.toString());
                }
            }
        }
    }
}
