package com.baidu.tieba.util;

import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class ak {
    public static void a(ListView listView, i iVar, int i, int i2) {
        a(listView, iVar, null, null, null, i, i2);
    }

    public static void a(ListView listView, i iVar, com.baidu.tbadk.imageManager.c cVar, com.baidu.tbadk.imageManager.c cVar2, com.baidu.tbadk.imageManager.c cVar3, int i, int i2) {
        int i3;
        int i4;
        LinkedList<String> photoUrl;
        com.baidu.adp.widget.ImageView.d a;
        boolean z;
        View findViewWithTag;
        int i5;
        int i6;
        int i7;
        View findViewWithTag2;
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
                    cVar2 = new an(listView);
                }
                com.baidu.tbadk.imageManager.c aoVar = cVar3 == null ? new ao(listView) : cVar3;
                int i8 = 0;
                try {
                    boolean a2 = a();
                    int i9 = 0;
                    int i10 = 0;
                    int i11 = 0;
                    boolean b = i.b();
                    int i12 = firstVisiblePosition;
                    while (true) {
                        if (i12 >= adapter.getCount()) {
                            i3 = i9;
                            break;
                        } else if (i12 > lastVisiblePosition && !a2) {
                            i3 = i9;
                            break;
                        } else if (i != 0) {
                            i3 = i9;
                            break;
                        } else {
                            Object item = adapter.getItem(i12);
                            boolean z2 = false;
                            if (item instanceof ar) {
                                ar arVar = (ar) item;
                                if (arVar.isSupportImageSize()) {
                                    LinkedList<aq> imagesWithEmotions = arVar.getImagesWithEmotions();
                                    if (imagesWithEmotions != null) {
                                        Iterator<aq> it = imagesWithEmotions.iterator();
                                        while (it.hasNext()) {
                                            aq next = it.next();
                                            if (!a2 && (findViewWithTag2 = listView.findViewWithTag(next.a())) != null && a(findViewWithTag2, listView)) {
                                                z = true;
                                                i5 = i10;
                                                i6 = i9;
                                                break;
                                            }
                                            i9++;
                                            int i13 = next.b * next.c;
                                            if (i13 > 0) {
                                                if (next.d != null) {
                                                    i10 += i13 * 4;
                                                } else {
                                                    i10 += i13 * 2;
                                                }
                                            } else if (next.d != null) {
                                                com.baidu.adp.lib.h.e.a("missing big emotion image width and height!");
                                                i10 += com.baidu.tieba.data.h.n();
                                            }
                                            if (i12 > lastVisiblePosition) {
                                                i7 = next.c + i11;
                                                if (i7 > com.baidu.adp.lib.h.g.c(TiebaApplication.g())) {
                                                    i5 = i10;
                                                    i6 = i9;
                                                    i11 = i7;
                                                    z = true;
                                                    break;
                                                }
                                            } else {
                                                i7 = i11;
                                            }
                                            i11 = i7;
                                        }
                                    }
                                    z = false;
                                    i5 = i10;
                                    i6 = i9;
                                    i9 = i6;
                                    i10 = i5;
                                } else if (i9 < 13) {
                                    LinkedList<String> imageUrl = arVar.getImageUrl();
                                    if (imageUrl != null) {
                                        Iterator<String> it2 = imageUrl.iterator();
                                        while (true) {
                                            if (!it2.hasNext()) {
                                                break;
                                            }
                                            String next2 = it2.next();
                                            if (!a2 && (findViewWithTag = listView.findViewWithTag(next2)) != null && a(findViewWithTag, listView)) {
                                                z2 = true;
                                                break;
                                            } else {
                                                i9++;
                                                i10 += com.baidu.tieba.data.h.m();
                                            }
                                        }
                                    }
                                    z = z2;
                                } else {
                                    z = true;
                                }
                                if (z) {
                                    i3 = i9;
                                    break;
                                }
                            }
                            i12++;
                        }
                    }
                    TiebaApplication.g().p((int) (i10 * 1.2f));
                    int i14 = 0;
                    int i15 = firstVisiblePosition;
                    while (i15 < adapter.getCount()) {
                        if (i15 <= lastVisiblePosition || a2) {
                            Object item2 = adapter.getItem(i15);
                            if (item2 instanceof ar) {
                                ar arVar2 = (ar) item2;
                                if (i14 < i3) {
                                    if (arVar2.isSupportImageSize()) {
                                        LinkedList<aq> imagesWithEmotions2 = arVar2.getImagesWithEmotions();
                                        if (imagesWithEmotions2 != null) {
                                            int i16 = 0;
                                            while (i16 < imagesWithEmotions2.size() && i14 < i3) {
                                                aq aqVar = imagesWithEmotions2.get(i16);
                                                int i17 = i14 + 1;
                                                if (aqVar.d == null) {
                                                    if (listView.findViewWithTag(aqVar.a) != null && (a = iVar.a(aqVar.a, cVar)) != null) {
                                                        cVar.a(a, aqVar.a, true);
                                                    }
                                                } else {
                                                    com.baidu.tbadk.widget.richText.e eVar = aqVar.d;
                                                    View findViewWithTag3 = listView.findViewWithTag(aqVar.a());
                                                    if (findViewWithTag3 != null) {
                                                        GifView gifView = (GifView) findViewWithTag3;
                                                        if (eVar.j) {
                                                            gifView.setGif(null);
                                                        } else {
                                                            String str = b ? eVar.b : eVar.a;
                                                            com.baidu.adp.lib.h.e.e("LoadImageHelper", "loadEmotion", "emotion dynamic:" + eVar.c);
                                                            com.baidu.adp.widget.ImageView.d a3 = iVar.a(eVar.e, eVar.c, str, b, aoVar);
                                                            if (a3 != null) {
                                                                gifView.setGif(a3);
                                                                gifView.setIsLoading(false);
                                                                eVar.j = false;
                                                            } else {
                                                                gifView.setIsLoading(true);
                                                            }
                                                        }
                                                    }
                                                }
                                                i16++;
                                                i14 = i17;
                                            }
                                        }
                                        i14 = i14;
                                    } else {
                                        LinkedList<String> imageUrl2 = arVar2.getImageUrl();
                                        if (imageUrl2 != null) {
                                            for (int i18 = 0; i18 < imageUrl2.size() && i14 < i3; i18++) {
                                                i14++;
                                                iVar.a(imageUrl2.get(i18), cVar);
                                            }
                                        }
                                    }
                                }
                                if (i8 < 30 && (photoUrl = arVar2.getPhotoUrl()) != null) {
                                    Iterator<String> it3 = photoUrl.iterator();
                                    while (it3.hasNext()) {
                                        String next3 = it3.next();
                                        i8++;
                                        if (i2 == 0) {
                                            iVar.d(next3, cVar2);
                                        } else if (i2 == 1) {
                                            iVar.b(next3, cVar2);
                                        }
                                    }
                                }
                                i4 = i8;
                                LinkedList<String> forumPhotoUrl = arVar2.getForumPhotoUrl();
                                if (forumPhotoUrl != null) {
                                    Iterator<String> it4 = forumPhotoUrl.iterator();
                                    int i19 = i4;
                                    while (it4.hasNext()) {
                                        i19++;
                                        iVar.f(it4.next(), cVar);
                                    }
                                    i4 = i19;
                                }
                            } else {
                                i4 = i8;
                            }
                            if (!a2 || i14 < i3 || i4 < 30) {
                                i15++;
                                i8 = i4;
                            } else {
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                } catch (Exception e) {
                    bo.b("LoadImageHelper", "loadListView", e.toString());
                }
            }
        }
    }

    private static boolean a() {
        return UtilHelper.g(TiebaApplication.g()) == UtilHelper.NetworkStateInfo.WIFI;
    }

    private static boolean a(View view, View view2) {
        int bottom = view.getBottom();
        int top = view.getTop();
        while (true) {
            View view3 = (View) view.getParent();
            if (view3 == null) {
                return false;
            }
            if (view3 == view2) {
                return top > view2.getBottom() || bottom < view2.getTop();
            }
            top += view3.getTop();
            bottom += view3.getBottom();
            view = view3;
        }
    }
}
