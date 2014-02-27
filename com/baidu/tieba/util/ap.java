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
public final class ap {
    public static void a(ListView listView, i iVar, int i, int i2) {
        a(listView, iVar, null, null, null, i, i2);
    }

    /* JADX WARN: Removed duplicated region for block: B:156:0x0054 A[EDGE_INSN: B:156:0x0054->B:18:0x0054 ?: BREAK  , SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:158:0x00fa A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(ListView listView, i iVar, com.baidu.tbadk.imageManager.d dVar, com.baidu.tbadk.imageManager.d dVar2, com.baidu.tbadk.imageManager.d dVar3, int i, int i2) {
        int i3;
        LinkedList<String> photoUrl;
        com.baidu.adp.widget.ImageView.b b;
        boolean z;
        View findViewWithTag;
        int i4;
        int i5;
        int i6;
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
                at atVar = new at(listView);
                try {
                    boolean z2 = UtilHelper.h(TiebaApplication.g().b()) == UtilHelper.NetworkStateInfo.WIFI;
                    int i7 = 0;
                    int i8 = 0;
                    int i9 = 0;
                    boolean b2 = i.b();
                    for (int i10 = firstVisiblePosition; i10 < adapter.getCount() && ((i10 <= lastVisiblePosition || z2) && i == 0); i10++) {
                        Object item = adapter.getItem(i10);
                        if (item instanceof aw) {
                            aw awVar = (aw) item;
                            if (awVar.isSupportImageSize()) {
                                LinkedList<av> imagesWithEmotions = awVar.getImagesWithEmotions();
                                if (imagesWithEmotions != null) {
                                    Iterator<av> it = imagesWithEmotions.iterator();
                                    while (it.hasNext()) {
                                        av next = it.next();
                                        if (z2 || (findViewWithTag2 = listView.findViewWithTag(next.a())) == null || !a(findViewWithTag2, listView)) {
                                            i7++;
                                            int i11 = next.b * next.c;
                                            if (i11 > 0) {
                                                if (next.d != null) {
                                                    i8 += i11 * 4;
                                                } else {
                                                    i8 += i11 * 2;
                                                }
                                            } else if (next.d != null) {
                                                com.baidu.adp.lib.util.e.b("missing big emotion image width and height!");
                                                i8 += com.baidu.tieba.data.i.y();
                                            }
                                            if (i10 > lastVisiblePosition) {
                                                i6 = next.c + i9;
                                                if (i6 > BdUtilHelper.c(TiebaApplication.g().b())) {
                                                    i5 = i8;
                                                    i4 = i7;
                                                    i7 = i4;
                                                    i8 = i5;
                                                    i9 = i6;
                                                    z = true;
                                                    break;
                                                }
                                                i9 = i6;
                                            }
                                        } else {
                                            i6 = i9;
                                            i5 = i8;
                                            i4 = i7;
                                            i7 = i4;
                                            i8 = i5;
                                            i9 = i6;
                                            z = true;
                                            break;
                                        }
                                    }
                                    z = false;
                                    if (z) {
                                        break;
                                    }
                                }
                                z = false;
                                if (z) {
                                }
                            } else {
                                if (i7 < 13) {
                                    LinkedList<String> imageUrl = awVar.getImageUrl();
                                    if (imageUrl != null) {
                                        Iterator<String> it2 = imageUrl.iterator();
                                        while (it2.hasNext()) {
                                            String next2 = it2.next();
                                            if (z2 || (findViewWithTag = listView.findViewWithTag(next2)) == null || !a(findViewWithTag, listView)) {
                                                i7++;
                                                i8 += com.baidu.tieba.data.i.x();
                                            }
                                        }
                                        z = false;
                                        if (z) {
                                        }
                                    }
                                    z = false;
                                    if (z) {
                                    }
                                }
                                i6 = i9;
                                i5 = i8;
                                i4 = i7;
                                i7 = i4;
                                i8 = i5;
                                i9 = i6;
                                z = true;
                                if (z) {
                                }
                            }
                        }
                    }
                    int i12 = i7;
                    TiebaApplication.g();
                    TiebaApplication.p((int) (i8 * 1.2f));
                    int i13 = 0;
                    int i14 = firstVisiblePosition;
                    int i15 = 0;
                    while (i14 < adapter.getCount()) {
                        if (i14 <= lastVisiblePosition || z2) {
                            Object item2 = adapter.getItem(i14);
                            if (item2 instanceof aw) {
                                aw awVar2 = (aw) item2;
                                if (i13 < i12) {
                                    if (awVar2.isSupportImageSize()) {
                                        LinkedList<av> imagesWithEmotions2 = awVar2.getImagesWithEmotions();
                                        if (imagesWithEmotions2 != null) {
                                            int i16 = 0;
                                            while (i16 < imagesWithEmotions2.size() && i13 < i12) {
                                                av avVar = imagesWithEmotions2.get(i16);
                                                int i17 = i13 + 1;
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
                                                            com.baidu.adp.lib.util.e.e("LoadImageHelper", "loadEmotion", "emotion dynamic:" + eVar.c);
                                                            com.baidu.adp.widget.ImageView.b a = iVar.a(eVar.e, eVar.c, str, b2, atVar);
                                                            if (a != null) {
                                                                gifView.setGif(a);
                                                                gifView.setIsLoading(false);
                                                                eVar.j = false;
                                                            } else {
                                                                gifView.setIsLoading(true);
                                                            }
                                                        }
                                                    }
                                                }
                                                i16++;
                                                i13 = i17;
                                            }
                                        }
                                    } else {
                                        LinkedList<String> imageUrl2 = awVar2.getImageUrl();
                                        if (imageUrl2 != null) {
                                            int i18 = i13;
                                            for (int i19 = 0; i19 < imageUrl2.size() && i18 < i12; i19++) {
                                                i18++;
                                                iVar.b(imageUrl2.get(i19), dVar);
                                            }
                                            i13 = i18;
                                        }
                                    }
                                }
                                if (i15 < 30 && (photoUrl = awVar2.getPhotoUrl()) != null) {
                                    Iterator<String> it3 = photoUrl.iterator();
                                    while (it3.hasNext()) {
                                        String next3 = it3.next();
                                        i15++;
                                        if (i2 == 0) {
                                            iVar.d(next3, dVar2);
                                        } else if (i2 == 1) {
                                            iVar.c(next3, dVar2);
                                        }
                                    }
                                }
                                i3 = i15;
                                LinkedList<String> forumPhotoUrl = awVar2.getForumPhotoUrl();
                                if (forumPhotoUrl != null) {
                                    Iterator<String> it4 = forumPhotoUrl.iterator();
                                    while (it4.hasNext()) {
                                        i3++;
                                        iVar.f(it4.next(), dVar);
                                    }
                                }
                            } else {
                                i3 = i15;
                            }
                            if (!z2 || i13 < i12 || i3 < 30) {
                                i14++;
                                i15 = i3;
                            } else {
                                return;
                            }
                        } else {
                            return;
                        }
                    }
                } catch (Exception e) {
                    com.baidu.adp.lib.util.e.b("LoadImageHelper", "loadListView", e.toString());
                }
            }
        }
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
