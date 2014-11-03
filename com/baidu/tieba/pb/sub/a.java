package com.baidu.tieba.pb.sub;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.style.TextAppearanceSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.data.ak;
import com.baidu.tieba.u;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.z;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class a extends BaseAdapter {
    protected View.OnClickListener bzZ;
    protected Context mContext;
    protected ArrayList<ak> aeE = null;
    protected View.OnClickListener bzY = null;
    protected int boZ = 0;
    protected boolean bAa = false;
    protected boolean bvK = false;
    protected boolean bAb = false;
    private boolean mIsFromCDN = true;

    public a(Context context, View.OnClickListener onClickListener) {
        this.mContext = null;
        this.bzZ = null;
        this.mContext = context;
        this.bzZ = onClickListener;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public int gZ(String str) {
        if (this.aeE == null) {
            return -1;
        }
        int size = this.aeE.size();
        for (int i = 0; i < size; i++) {
            if (this.aeE.get(i).getId().equals(str)) {
                return i;
            }
        }
        return -1;
    }

    public void setDatas(ArrayList<ak> arrayList) {
        if (arrayList == null) {
            this.aeE = new ArrayList<>();
            return;
        }
        Iterator<ak> it = arrayList.iterator();
        while (it.hasNext()) {
            ak next = it.next();
            if (next != null && next.getAuthor() != null) {
                next.getAuthor().setPortrait(null);
            }
        }
        this.aeE = arrayList;
    }

    public void u(View.OnClickListener onClickListener) {
        this.bzY = onClickListener;
    }

    public void t(int i, boolean z) {
        this.boZ = i;
        this.bAa = z;
    }

    public void dY(boolean z) {
        this.bvK = false;
    }

    public void en(boolean z) {
        this.bAb = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aeE == null) {
            return 0;
        }
        return this.aeE.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aeE == null || i < 0 || i >= this.aeE.size()) {
            return null;
        }
        return this.aeE.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = hA();
        }
        b bVar = (b) ((SparseArray) view.getTag()).get(v.tag_holder);
        if (getItem(i) != null) {
            a(bVar, (ak) getItem(i), !(!this.bAb && i + 1 >= getCount()), i == 0);
        }
        return view;
    }

    public View hA() {
        b bVar = new b(this);
        View inflate = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, w.new_sub_pb_list_item, null);
        bVar.Xm = inflate;
        bVar.bAc = (LinearLayout) inflate.findViewById(v.sub_pb_item_columnlayout);
        bVar.bAd = (TextView) inflate.findViewById(v.manage_btn);
        bVar.bwi = (TbRichTextView) inflate.findViewById(v.new_sub_pb_list_richText);
        bVar.bwi.setTextSize(TbConfig.getContentSizeOfLzl(this.mContext));
        bVar.bwi.setTextColor(aw.getColor(com.baidu.tieba.s.gray_day_3));
        bVar.bAd.setOnClickListener(this.bzY);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(v.tag_holder, bVar);
        inflate.setTag(sparseArray);
        return inflate;
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0145 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x023c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(b bVar, ak akVar, boolean z, boolean z2) {
        boolean z3;
        boolean z4;
        boolean z5;
        SparseArray sparseArray;
        com.baidu.tbadk.widget.richText.c cVar;
        TextAppearanceSpan textAppearanceSpan;
        if (bVar != null && akVar != null) {
            bVar.bwi.setPadding(0, 0, 0, 0);
            int skinType = TbadkApplication.m251getInst().getSkinType();
            if (akVar.getAuthor() != null) {
                String userName = akVar.getAuthor().getUserName();
                SparseArray sparseArray2 = (SparseArray) bVar.Xm.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    bVar.Xm.setTag(sparseArray2);
                }
                sparseArray2.put(v.tag_photo_username, userName);
                sparseArray2.put(v.tag_clip_board, akVar);
                sparseArray2.put(v.tag_is_subpb, true);
            }
            bVar.bwi.setLinkTextColor(aw.getColor(com.baidu.tieba.s.common_link_text));
            com.baidu.tbadk.widget.richText.a Ah = akVar.Ah();
            if (Ah != null) {
                ArrayList<com.baidu.tbadk.widget.richText.c> vA = Ah.vA();
                if (vA.size() > 0) {
                    com.baidu.tbadk.widget.richText.c cVar2 = vA.get(vA.size() - 1);
                    int type = cVar2.getType();
                    String str = "";
                    if (type == 1) {
                        str = (vA.size() <= 1 || vA.get(vA.size() + (-2)).getType() == type) ? "  " + az.j(akVar.getTime()) : az.j(akVar.getTime());
                        SpannableStringBuilder vG = cVar2.vG();
                        if (Ah.abr) {
                            vG.delete(vG.length() - Ah.abt, vG.length());
                        }
                        vG.append((CharSequence) str);
                        Ah.abr = true;
                        Ah.abt = str.length();
                        cVar = cVar2;
                    } else if (Ah.abr) {
                        cVar = cVar2;
                    } else {
                        str = az.j(akVar.getTime());
                        com.baidu.tbadk.widget.richText.c cVar3 = new com.baidu.tbadk.widget.richText.c(1);
                        cVar3.append(str);
                        Ah.abr = true;
                        Ah.abt = str.length();
                        vA.add(cVar3);
                        cVar = cVar3;
                    }
                    if (skinType == 1) {
                        textAppearanceSpan = new TextAppearanceSpan(this.mContext, z.subtext_1);
                    } else {
                        textAppearanceSpan = new TextAppearanceSpan(this.mContext, z.subtext);
                    }
                    SpannableStringBuilder vG2 = cVar.vG();
                    vG2.setSpan(textAppearanceSpan, vG2.length() - str.length(), vG2.length(), 33);
                }
                bVar.bwi.setVoiceViewRes(w.voice_play_btn);
                bVar.bwi.setIsFromCDN(this.mIsFromCDN);
                bVar.bwi.setText(akVar.Ah());
            }
            boolean z6 = false;
            boolean z7 = false;
            String userId = akVar.getAuthor().getUserId();
            if (this.boZ != 0) {
                z6 = true;
                z7 = true;
                if (userId != null && userId.equals(TbadkApplication.getCurrentAccount())) {
                    z6 = false;
                }
                if (userId == null || userId.equals("0") || userId.length() == 0) {
                    z3 = false;
                    z4 = true;
                    z5 = false;
                    if (!z4 && z3) {
                        bVar.bAd.setVisibility(0);
                        bVar.bAd.setCompoundDrawablesWithIntrinsicBounds(aw.getDrawable(u.icon_floor_manage_n), (Drawable) null, (Drawable) null, (Drawable) null);
                    } else if (z4) {
                        bVar.bAd.setVisibility(0);
                        bVar.bAd.setCompoundDrawablesWithIntrinsicBounds(aw.getDrawable(u.icon_floor_delete_n), (Drawable) null, (Drawable) null, (Drawable) null);
                    } else {
                        bVar.bAd.setVisibility(8);
                    }
                    sparseArray = (SparseArray) bVar.bAd.getTag();
                    if (sparseArray == null) {
                        sparseArray = new SparseArray();
                        bVar.bAd.setTag(sparseArray);
                    }
                    if (bVar.bAd.getVisibility() == 0) {
                        sparseArray.put(v.tag_manage_user_identity, Integer.valueOf(this.boZ));
                    }
                    if (z4) {
                        sparseArray.put(v.tag_del_post_is_self, Boolean.valueOf(z5));
                        sparseArray.put(v.tag_del_post_type, 2);
                        sparseArray.put(v.tag_del_post_id, akVar.getId());
                    } else {
                        sparseArray.put(v.tag_del_post_is_self, Boolean.valueOf(z5));
                        sparseArray.put(v.tag_del_post_type, 0);
                        sparseArray.put(v.tag_del_post_id, "");
                    }
                    if (z3) {
                        sparseArray.put(v.tag_forbid_user_name, akVar.getAuthor().getUserName());
                        return;
                    } else {
                        sparseArray.put(v.tag_forbid_user_name, "");
                        return;
                    }
                }
                z3 = z6;
                z4 = z7;
                z5 = false;
                if (!z4) {
                }
                if (z4) {
                }
                sparseArray = (SparseArray) bVar.bAd.getTag();
                if (sparseArray == null) {
                }
                if (bVar.bAd.getVisibility() == 0) {
                }
                if (z4) {
                }
                if (z3) {
                }
            } else {
                if (this.bAa) {
                    z3 = false;
                    z4 = true;
                    z5 = false;
                } else {
                    if (userId != null && userId.equals(TbadkApplication.getCurrentAccount())) {
                        z3 = false;
                        z4 = true;
                        z5 = true;
                    }
                    z3 = z6;
                    z4 = z7;
                    z5 = false;
                }
                if (!z4) {
                }
                if (z4) {
                }
                sparseArray = (SparseArray) bVar.bAd.getTag();
                if (sparseArray == null) {
                }
                if (bVar.bAd.getVisibility() == 0) {
                }
                if (z4) {
                }
                if (z3) {
                }
            }
        }
    }
}
