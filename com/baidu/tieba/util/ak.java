package com.baidu.tieba.util;

import android.widget.ListAdapter;
import android.widget.ListView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class ak {
    public static void a(ListView listView, i iVar, int i, int i2) {
        a(listView, iVar, null, null, i, i2);
    }

    public static void a(ListView listView, i iVar, com.baidu.tbadk.imageManager.c cVar, com.baidu.tbadk.imageManager.c cVar2, int i, int i2) {
        boolean z;
        int i3;
        int i4;
        LinkedList<String> photoUrl;
        LinkedList<String> imageUrl;
        if (listView != null && iVar != null) {
            iVar.a();
            int firstVisiblePosition = listView.getFirstVisiblePosition();
            int lastVisiblePosition = listView.getLastVisiblePosition();
            ListAdapter adapter = listView.getAdapter();
            if (adapter != null) {
                if (cVar == null) {
                    cVar = new al(listView);
                }
                if (cVar2 == null) {
                    cVar2 = new am(listView);
                }
                int i5 = 0;
                try {
                    UtilHelper.NetworkStateInfo i6 = UtilHelper.i(TiebaApplication.g());
                    if (i6 == UtilHelper.NetworkStateInfo.WIFI || i6 == UtilHelper.NetworkStateInfo.ThreeG) {
                        z = true;
                    } else {
                        z = false;
                    }
                    int i7 = firstVisiblePosition;
                    int i8 = 0;
                    while (i7 < adapter.getCount()) {
                        if (i7 <= lastVisiblePosition || z) {
                            if (adapter.getItem(i7) instanceof an) {
                                an anVar = (an) adapter.getItem(i7);
                                if (i != 0 || i8 >= 13 || (imageUrl = anVar.getImageUrl()) == null) {
                                    i4 = i8;
                                } else {
                                    Iterator<String> it = imageUrl.iterator();
                                    i4 = i8;
                                    while (it.hasNext()) {
                                        i4++;
                                        iVar.a(it.next(), cVar);
                                    }
                                }
                                if (i5 < 30 && (photoUrl = anVar.getPhotoUrl()) != null) {
                                    Iterator<String> it2 = photoUrl.iterator();
                                    while (it2.hasNext()) {
                                        String next = it2.next();
                                        i5++;
                                        if (i2 == 0) {
                                            iVar.d(next, cVar2);
                                        } else if (i2 == 1) {
                                            iVar.b(next, cVar2);
                                        }
                                    }
                                }
                                int i9 = i5;
                                LinkedList<String> forumPhotoUrl = anVar.getForumPhotoUrl();
                                if (forumPhotoUrl != null) {
                                    Iterator<String> it3 = forumPhotoUrl.iterator();
                                    while (it3.hasNext()) {
                                        i9++;
                                        iVar.f(it3.next(), cVar);
                                    }
                                }
                                i3 = i9;
                                if (z && i4 >= 13 && i3 >= 30) {
                                    return;
                                }
                                i8 = i4;
                            } else {
                                i3 = i5;
                            }
                            i7++;
                            i5 = i3;
                        } else {
                            return;
                        }
                    }
                } catch (Exception e) {
                    bg.b("LoadImageHelper", "loadListView", e.toString());
                }
            }
        }
    }
}
