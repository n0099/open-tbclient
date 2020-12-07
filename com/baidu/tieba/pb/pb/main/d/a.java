package com.baidu.tieba.pb.pb.main.d;

import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.util.SparseArray;
import com.baidu.tbadk.core.dialog.g;
import com.baidu.tbadk.core.dialog.k;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.pb.pb.main.ay;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/* loaded from: classes22.dex */
public class a {
    public static int HE(int i) {
        switch (i) {
            case -4:
                return 4;
            case -3:
                return 3;
            case -2:
                return 2;
            case -1:
                return 1;
            case 0:
            case 1:
            case 2:
            case 3:
            default:
                return 0;
            case 4:
                return 5;
            case 5:
                return 7;
            case 6:
                return 6;
            case 7:
                return 9;
            case 8:
                return 8;
        }
    }

    public static List<g> fs(List<g> list) {
        if (list != null) {
            for (g gVar : list) {
                gVar.setDrawable(d(gVar));
            }
        }
        return list;
    }

    public static Drawable d(g gVar) {
        switch (gVar.getId()) {
            case -4:
                return WebPManager.a(R.drawable.icon_pure_pb_recommend_share30, ap.getColor(R.color.CAM_X0107), (WebPManager.ResourceStateType) null);
            case -3:
                return WebPManager.a(R.drawable.icon_pure_pb_recommend_comment30, ap.getColor(R.color.CAM_X0107), (WebPManager.ResourceStateType) null);
            case -2:
                if (ay.getString(R.string.c_disagree, new Object[0]).equals(gVar.brG())) {
                    return WebPManager.a(R.drawable.icon_pure_pb_recommend_dislike30, ap.getColor(R.color.CAM_X0107), (WebPManager.ResourceStateType) null);
                }
                return WebPManager.a(R.drawable.icon_pure_pb_recommend_disliked30, ap.getColor(R.color.CAM_X0107), (WebPManager.ResourceStateType) null);
            case -1:
                if (ay.getString(R.string.c_agree, new Object[0]).equals(gVar.brG())) {
                    return WebPManager.a(R.drawable.icon_pure_pb_recommend_like30, ap.getColor(R.color.CAM_X0107), (WebPManager.ResourceStateType) null);
                }
                return WebPManager.a(R.drawable.icon_pure_pb_recommend_liked30, ap.getColor(R.color.CAM_X0301), (WebPManager.ResourceStateType) null);
            case 0:
            case 9:
            default:
                return null;
            case 1:
                return WebPManager.a(R.drawable.icon_pure_pb_recommend_expression30, ap.getColor(R.color.CAM_X0107), (WebPManager.ResourceStateType) null);
            case 2:
                return WebPManager.a(R.drawable.icon_pure_pb_recommend_save30, ap.getColor(R.color.CAM_X0107), (WebPManager.ResourceStateType) null);
            case 3:
                return WebPManager.a(R.drawable.icon_pure_pb_recommend_copy30, ap.getColor(R.color.CAM_X0107), (WebPManager.ResourceStateType) null);
            case 4:
                if (ay.getString(R.string.mark, new Object[0]).equals(gVar.brG())) {
                    return WebPManager.a(R.drawable.icon_pure_pb_recommend_collect30, ap.getColor(R.color.CAM_X0107), (WebPManager.ResourceStateType) null);
                }
                return WebPManager.a(R.drawable.icon_pure_pb_recommend_collected30, ap.getColor(R.color.CAM_X0305), (WebPManager.ResourceStateType) null);
            case 5:
                if (ay.getString(R.string.report_text, new Object[0]).equals(gVar.brG())) {
                    return WebPManager.a(R.drawable.icon_pure_pb_recommend_report30, ap.getColor(R.color.CAM_X0107), (WebPManager.ResourceStateType) null);
                }
                if (ay.getString(R.string.mute_option, new Object[0]).equals(gVar.brG())) {
                    return WebPManager.a(R.drawable.icon_pure_pb_recommend_nospeakingset30, ap.getColor(R.color.CAM_X0107), (WebPManager.ResourceStateType) null);
                }
                return null;
            case 6:
                if (ay.getString(R.string.report_text, new Object[0]).equals(gVar.brG())) {
                    return WebPManager.a(R.drawable.icon_pure_pb_recommend_report30, ap.getColor(R.color.CAM_X0107), (WebPManager.ResourceStateType) null);
                }
                if (ay.getString(R.string.delete, new Object[0]).equals(gVar.brG())) {
                    return WebPManager.a(R.drawable.icon_pure_pb_recommend_delete30, ap.getColor(R.color.CAM_X0107), (WebPManager.ResourceStateType) null);
                }
                return null;
            case 7:
                return WebPManager.a(R.drawable.icon_pure_pb_recommend_administration30, ap.getColor(R.color.CAM_X0107), (WebPManager.ResourceStateType) null);
            case 8:
                return WebPManager.a(R.drawable.icon_pure_pb_recommend_hide30, ap.getColor(R.color.CAM_X0107), (WebPManager.ResourceStateType) null);
            case 10:
                if (ay.getString(R.string.delete_post, new Object[0]).equals(gVar.brG())) {
                    return WebPManager.a(R.drawable.icon_pure_pb_recommend_delete30, ap.getColor(R.color.CAM_X0107), (WebPManager.ResourceStateType) null);
                }
                if (ay.getString(R.string.delete, new Object[0]).equals(gVar.brG())) {
                    return WebPManager.a(R.drawable.icon_pure_pb_recommend_delete30, ap.getColor(R.color.CAM_X0107), (WebPManager.ResourceStateType) null);
                }
                return null;
            case 11:
                return WebPManager.a(R.drawable.icon_pure_pb_recommend_block30, ap.getColor(R.color.CAM_X0107), (WebPManager.ResourceStateType) null);
            case 12:
                if (ay.getString(R.string.mute, new Object[0]).equals(gVar.brG())) {
                    return WebPManager.a(R.drawable.icon_pure_pb_recommend_nospeaking30, ap.getColor(R.color.CAM_X0107), (WebPManager.ResourceStateType) null);
                }
                if (ay.getString(R.string.un_mute, new Object[0]).equals(gVar.brG())) {
                    return WebPManager.a(R.drawable.icon_pure_pb_recommend_nospeakinged30, ap.getColor(R.color.CAM_X0107), (WebPManager.ResourceStateType) null);
                }
                return null;
        }
    }

    public static List<g> a(List<g> list, AgreeData agreeData, SparseArray<Object> sparseArray, k kVar) {
        if (list == null) {
            list = new ArrayList<>();
        }
        ArrayList arrayList = new ArrayList();
        if (agreeData.hasAgree) {
            if (agreeData.agreeType == 2) {
                g gVar = new g(-1, ay.getString(R.string.c_agreeed, new Object[0]), kVar);
                gVar.eNK.setTag(sparseArray);
                arrayList.add(gVar);
                if (sparseArray == null || sparseArray.get(R.id.pb_dialog_item_isugc) == null || !((Boolean) sparseArray.get(R.id.pb_dialog_item_isugc)).booleanValue()) {
                    g gVar2 = new g(-2, ay.getString(R.string.c_disagree, new Object[0]), kVar);
                    gVar2.eNK.setTag(sparseArray);
                    arrayList.add(gVar2);
                }
            } else {
                g gVar3 = new g(-1, ay.getString(R.string.c_agree, new Object[0]), kVar);
                gVar3.eNK.setTag(sparseArray);
                arrayList.add(gVar3);
                if (sparseArray == null || sparseArray.get(R.id.pb_dialog_item_isugc) == null || !((Boolean) sparseArray.get(R.id.pb_dialog_item_isugc)).booleanValue()) {
                    g gVar4 = new g(-2, ay.getString(R.string.c_disagreeed, new Object[0]), kVar);
                    gVar4.eNK.setTag(sparseArray);
                    arrayList.add(gVar4);
                }
            }
        } else {
            g gVar5 = new g(-1, ay.getString(R.string.c_agree, new Object[0]), kVar);
            gVar5.eNK.setTag(sparseArray);
            arrayList.add(gVar5);
            if (sparseArray == null || sparseArray.get(R.id.pb_dialog_item_isugc) == null || !((Boolean) sparseArray.get(R.id.pb_dialog_item_isugc)).booleanValue()) {
                g gVar6 = new g(-2, ay.getString(R.string.c_disagree, new Object[0]), kVar);
                gVar6.eNK.setTag(sparseArray);
                arrayList.add(gVar6);
            }
        }
        g gVar7 = new g(-3, ay.getString(R.string.reply, new Object[0]), kVar);
        gVar7.eNK.setTag(sparseArray);
        arrayList.add(gVar7);
        g gVar8 = new g(-4, ay.getString(R.string.share, new Object[0]), kVar);
        gVar8.eNK.setTag(sparseArray);
        arrayList.add(gVar8);
        list.addAll(0, arrayList);
        return list;
    }

    public static List<g> v(List<g> list, boolean z) {
        if (list != null && !z) {
            Iterator<g> it = list.iterator();
            while (it.hasNext()) {
                g next = it.next();
                if (next.getId() == 2 || next.getId() == 1 || next.getId() == 3) {
                    it.remove();
                }
            }
        }
        return list;
    }

    public static SpannableStringBuilder t(PostData postData) {
        if (postData == null) {
            return null;
        }
        String str = "";
        if (postData.dPi() != null) {
            str = postData.dPi().toString();
        }
        SpannableString bB = bB(postData.boP().getName_show() + " : ", ap.getColor(R.color.CAM_X0109));
        SpannableString bB2 = bB(str, ap.getColor(R.color.CAM_X0107));
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        spannableStringBuilder.append((CharSequence) bB);
        spannableStringBuilder.append((CharSequence) bB2);
        return spannableStringBuilder;
    }

    public static SpannableString bB(String str, int i) {
        SpannableString spannableString = new SpannableString(str);
        spannableString.setSpan(new ForegroundColorSpan(i), 0, str.length(), 33);
        return spannableString;
    }
}
