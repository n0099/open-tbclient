package com.baidu.tieba.util;

import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.tbadk.gif.GifView;
import com.baidu.tieba.TiebaApplication;
import com.baidu.tieba.util.UtilHelper;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes.dex */
public class ap {
    public static void a(ListView listView, i iVar, int i, int i2) {
        a(listView, iVar, null, null, null, i, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:158:0x00f1 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01aa A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(ListView listView, i iVar, com.baidu.tbadk.imageManager.d dVar, com.baidu.tbadk.imageManager.d dVar2, com.baidu.tbadk.imageManager.d dVar3, int i, int i2) {
        int i3;
        int i4;
        int i5;
        LinkedList<String> photoUrl;
        com.baidu.adp.widget.ImageView.b b;
        int i6;
        int i7;
        int i8;
        boolean z;
        View findViewWithTag;
        View findViewWithTag2;
        if (listView != null && iVar != null) {
            iVar.a();
            int firstVisiblePosition = listView.getFirstVisiblePosition();
            int lastVisiblePosition = listView.getLastVisiblePosition();
            ListAdapter adapter = listView.getAdapter();
            if (adapter != null) {
                if (dVar == null) {
                    dVar = new aq(listView);
                }
                if (dVar2 == null) {
                    dVar2 = new as(listView);
                }
                com.baidu.tbadk.imageManager.d atVar = dVar3 == null ? new at(listView) : dVar3;
                int i9 = 0;
                try {
                    boolean a = a();
                    int i10 = 0;
                    int i11 = 0;
                    int i12 = 0;
                    boolean b2 = i.b();
                    int i13 = firstVisiblePosition;
                    while (true) {
                        if (i13 >= adapter.getCount()) {
                            i3 = i10;
                            break;
                        } else if (i13 > lastVisiblePosition && !a) {
                            i3 = i10;
                            break;
                        } else if (i != 0) {
                            i3 = i10;
                            break;
                        } else {
                            Object item = adapter.getItem(i13);
                            if (item instanceof aw) {
                                aw awVar = (aw) item;
                                if (awVar.isSupportImageSize()) {
                                    LinkedList<av> imagesWithEmotions = awVar.getImagesWithEmotions();
                                    if (imagesWithEmotions != null) {
                                        Iterator<av> it = imagesWithEmotions.iterator();
                                        while (true) {
                                            if (!it.hasNext()) {
                                                i6 = i12;
                                                i7 = i11;
                                                i8 = i10;
                                                z = false;
                                                break;
                                            }
                                            av next = it.next();
                                            if (!a && (findViewWithTag2 = listView.findViewWithTag(next.a())) != null && a(findViewWithTag2, listView)) {
                                                i6 = i12;
                                                i7 = i11;
                                                i8 = i10;
                                                z = true;
                                                break;
                                            }
                                            i10++;
                                            int i14 = next.b * next.c;
                                            if (i14 > 0) {
                                                if (next.d != null) {
                                                    i11 += i14 * 4;
                                                } else {
                                                    i11 += i14 * 2;
                                                }
                                            } else if (next.d != null) {
                                                com.baidu.adp.lib.util.f.b("missing big emotion image width and height!");
                                                i11 += com.baidu.tieba.data.i.y();
                                            }
                                            if (i13 > lastVisiblePosition && (i12 = i12 + next.c) > BdUtilHelper.c(TiebaApplication.g().b())) {
                                                i6 = i12;
                                                i7 = i11;
                                                i8 = i10;
                                                z = true;
                                                break;
                                            }
                                        }
                                        if (z) {
                                            i3 = i8;
                                            i11 = i7;
                                            break;
                                        }
                                    }
                                    i6 = i12;
                                    i7 = i11;
                                    i8 = i10;
                                    z = false;
                                    if (z) {
                                    }
                                } else {
                                    if (i10 < 13) {
                                        LinkedList<String> imageUrl = awVar.getImageUrl();
                                        if (imageUrl != null) {
                                            Iterator<String> it2 = imageUrl.iterator();
                                            while (true) {
                                                if (!it2.hasNext()) {
                                                    i6 = i12;
                                                    i7 = i11;
                                                    i8 = i10;
                                                    z = false;
                                                    break;
                                                }
                                                String next2 = it2.next();
                                                if (!a && (findViewWithTag = listView.findViewWithTag(next2)) != null && a(findViewWithTag, listView)) {
                                                    i6 = i12;
                                                    i7 = i11;
                                                    i8 = i10;
                                                    z = true;
                                                    break;
                                                }
                                                i10++;
                                                i11 += com.baidu.tieba.data.i.x();
                                            }
                                        }
                                        i6 = i12;
                                        i7 = i11;
                                        i8 = i10;
                                        z = false;
                                    } else {
                                        i6 = i12;
                                        i7 = i11;
                                        i8 = i10;
                                        z = true;
                                    }
                                    if (z) {
                                    }
                                }
                            } else {
                                i6 = i12;
                                i7 = i11;
                                i8 = i10;
                            }
                            i13++;
                            i10 = i8;
                            i11 = i7;
                            i12 = i6;
                        }
                    }
                    TiebaApplication.g().p((int) (i11 * 1.2f));
                    int i15 = 0;
                    int i16 = firstVisiblePosition;
                    while (i16 < adapter.getCount()) {
                        if (i16 <= lastVisiblePosition || a) {
                            Object item2 = adapter.getItem(i16);
                            if (item2 instanceof aw) {
                                aw awVar2 = (aw) item2;
                                if (i15 < i3) {
                                    if (awVar2.isSupportImageSize()) {
                                        LinkedList<av> imagesWithEmotions2 = awVar2.getImagesWithEmotions();
                                        if (imagesWithEmotions2 != null) {
                                            int i17 = 0;
                                            while (i17 < imagesWithEmotions2.size() && i15 < i3) {
                                                av avVar = imagesWithEmotions2.get(i17);
                                                int i18 = i15 + 1;
                                                if (avVar.d == null) {
                                                    if (listView.findViewWithTag(avVar.a) != null && (b = iVar.b(avVar.a, dVar)) != null) {
                                                        dVar.a(b, avVar.a, true);
                                                    }
                                                } else {
                                                    com.baidu.tbadk.widget.richText.e eVar = avVar.d;
                                                    View findViewWithTag3 = listView.findViewWithTag(avVar.a());
                                                    if (findViewWithTag3 != null) {
                                                        GifView gifView = (GifView) findViewWithTag3;
                                                        if (eVar.j) {
                                                            gifView.setGif(null);
                                                        } else if (!eVar.k) {
                                                            String str = b2 ? eVar.b : eVar.a;
                                                            com.baidu.adp.lib.util.f.e("LoadImageHelper", "loadEmotion", "emotion dynamic:" + eVar.c);
                                                            com.baidu.adp.widget.ImageView.b a2 = iVar.a(eVar.e, eVar.c, str, b2, atVar);
                                                            if (a2 != null) {
                                                                gifView.setGif(a2);
                                                                gifView.setIsLoading(false);
                                                                eVar.j = false;
                                                            } else {
                                                                gifView.setIsLoading(true);
                                                            }
                                                        }
                                                    }
                                                }
                                                i17++;
                                                i15 = i18;
                                            }
                                        }
                                    } else {
                                        LinkedList<String> imageUrl2 = awVar2.getImageUrl();
                                        if (imageUrl2 != null) {
                                            for (int i19 = 0; i19 < imageUrl2.size() && i15 < i3; i19++) {
                                                i15++;
                                                iVar.b(imageUrl2.get(i19), dVar);
                                            }
                                        }
                                    }
                                }
                                if (i9 < 30 && (photoUrl = awVar2.getPhotoUrl()) != null) {
                                    Iterator<String> it3 = photoUrl.iterator();
                                    while (it3.hasNext()) {
                                        String next3 = it3.next();
                                        i9++;
                                        if (i2 == 0) {
                                            iVar.d(next3, dVar2);
                                        } else if (i2 == 1) {
                                            iVar.c(next3, dVar2);
                                        }
                                    }
                                }
                                int i20 = i9;
                                LinkedList<String> forumPhotoUrl = awVar2.getForumPhotoUrl();
                                if (forumPhotoUrl != null) {
                                    Iterator<String> it4 = forumPhotoUrl.iterator();
                                    int i21 = i20;
                                    while (it4.hasNext()) {
                                        i21++;
                                        iVar.f(it4.next(), dVar);
                                    }
                                    i4 = i15;
                                    i5 = i21;
                                } else {
                                    int i22 = i15;
                                    i5 = i20;
                                    i4 = i22;
                                }
                            } else {
                                i4 = i15;
                                i5 = i9;
                            }
                            if (!a || i4 < i3 || i5 < 30) {
                                i16++;
                                i9 = i5;
                                i15 = i4;
                            } else {
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                } catch (Exception e) {
                    com.baidu.adp.lib.util.f.b("LoadImageHelper", "loadListView", e.toString());
                }
            }
        }
    }

    private static boolean a() {
        return UtilHelper.h(TiebaApplication.g().b()) == UtilHelper.NetworkStateInfo.WIFI;
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
