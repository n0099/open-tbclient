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
import com.baidu.tbadk.core.util.ay;
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
    protected View.OnClickListener bzL;
    protected Context mContext;
    protected ArrayList<ak> aew = null;
    protected View.OnClickListener bzK = null;
    protected int boL = 0;
    protected boolean bzM = false;
    protected boolean bvw = false;
    protected boolean bzN = false;
    private boolean mIsFromCDN = true;

    public a(Context context, View.OnClickListener onClickListener) {
        this.mContext = null;
        this.bzL = null;
        this.mContext = context;
        this.bzL = onClickListener;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public int gZ(String str) {
        if (this.aew == null) {
            return -1;
        }
        int size = this.aew.size();
        for (int i = 0; i < size; i++) {
            if (this.aew.get(i).getId().equals(str)) {
                return i;
            }
        }
        return -1;
    }

    public void setDatas(ArrayList<ak> arrayList) {
        if (arrayList == null) {
            this.aew = new ArrayList<>();
            return;
        }
        Iterator<ak> it = arrayList.iterator();
        while (it.hasNext()) {
            ak next = it.next();
            if (next != null && next.getAuthor() != null) {
                next.getAuthor().setPortrait(null);
            }
        }
        this.aew = arrayList;
    }

    public void u(View.OnClickListener onClickListener) {
        this.bzK = onClickListener;
    }

    public void t(int i, boolean z) {
        this.boL = i;
        this.bzM = z;
    }

    public void dY(boolean z) {
        this.bvw = false;
    }

    public void en(boolean z) {
        this.bzN = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.aew == null) {
            return 0;
        }
        return this.aew.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.aew == null || i < 0 || i >= this.aew.size()) {
            return null;
        }
        return this.aew.get(i);
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
            a(bVar, (ak) getItem(i), !(!this.bzN && i + 1 >= getCount()), i == 0);
        }
        return view;
    }

    public View hA() {
        b bVar = new b(this);
        View inflate = com.baidu.adp.lib.g.b.ek().inflate(this.mContext, w.new_sub_pb_list_item, null);
        bVar.Xi = inflate;
        bVar.bzO = (LinearLayout) inflate.findViewById(v.sub_pb_item_columnlayout);
        bVar.bzP = (TextView) inflate.findViewById(v.manage_btn);
        bVar.bvU = (TbRichTextView) inflate.findViewById(v.new_sub_pb_list_richText);
        bVar.bvU.setTextSize(TbConfig.getContentSizeOfLzl(this.mContext));
        bVar.bvU.setTextColor(aw.getColor(com.baidu.tieba.s.gray_day_3));
        bVar.bzP.setOnClickListener(this.bzK);
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
            bVar.bvU.setPadding(0, 0, 0, 0);
            int skinType = TbadkApplication.m251getInst().getSkinType();
            if (akVar.getAuthor() != null) {
                String userName = akVar.getAuthor().getUserName();
                SparseArray sparseArray2 = (SparseArray) bVar.Xi.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    bVar.Xi.setTag(sparseArray2);
                }
                sparseArray2.put(v.tag_photo_username, userName);
                sparseArray2.put(v.tag_clip_board, akVar);
                sparseArray2.put(v.tag_is_subpb, true);
            }
            bVar.bvU.setLinkTextColor(aw.getColor(com.baidu.tieba.s.common_link_text));
            com.baidu.tbadk.widget.richText.a Af = akVar.Af();
            if (Af != null) {
                ArrayList<com.baidu.tbadk.widget.richText.c> vy = Af.vy();
                if (vy.size() > 0) {
                    com.baidu.tbadk.widget.richText.c cVar2 = vy.get(vy.size() - 1);
                    int type = cVar2.getType();
                    String str = "";
                    if (type == 1) {
                        str = (vy.size() <= 1 || vy.get(vy.size() + (-2)).getType() == type) ? "  " + ay.j(akVar.getTime()) : ay.j(akVar.getTime());
                        SpannableStringBuilder vE = cVar2.vE();
                        if (Af.abm) {
                            vE.delete(vE.length() - Af.abn, vE.length());
                        }
                        vE.append((CharSequence) str);
                        Af.abm = true;
                        Af.abn = str.length();
                        cVar = cVar2;
                    } else if (Af.abm) {
                        cVar = cVar2;
                    } else {
                        str = ay.j(akVar.getTime());
                        com.baidu.tbadk.widget.richText.c cVar3 = new com.baidu.tbadk.widget.richText.c(1);
                        cVar3.append(str);
                        Af.abm = true;
                        Af.abn = str.length();
                        vy.add(cVar3);
                        cVar = cVar3;
                    }
                    if (skinType == 1) {
                        textAppearanceSpan = new TextAppearanceSpan(this.mContext, z.subtext_1);
                    } else {
                        textAppearanceSpan = new TextAppearanceSpan(this.mContext, z.subtext);
                    }
                    SpannableStringBuilder vE2 = cVar.vE();
                    vE2.setSpan(textAppearanceSpan, vE2.length() - str.length(), vE2.length(), 33);
                }
                bVar.bvU.setVoiceViewRes(w.voice_play_btn);
                bVar.bvU.setIsFromCDN(this.mIsFromCDN);
                bVar.bvU.setText(akVar.Af());
            }
            boolean z6 = false;
            boolean z7 = false;
            String userId = akVar.getAuthor().getUserId();
            if (this.boL != 0) {
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
                        bVar.bzP.setVisibility(0);
                        bVar.bzP.setCompoundDrawablesWithIntrinsicBounds(aw.getDrawable(u.icon_floor_manage_n), (Drawable) null, (Drawable) null, (Drawable) null);
                    } else if (z4) {
                        bVar.bzP.setVisibility(0);
                        bVar.bzP.setCompoundDrawablesWithIntrinsicBounds(aw.getDrawable(u.icon_floor_delete_n), (Drawable) null, (Drawable) null, (Drawable) null);
                    } else {
                        bVar.bzP.setVisibility(8);
                    }
                    sparseArray = (SparseArray) bVar.bzP.getTag();
                    if (sparseArray == null) {
                        sparseArray = new SparseArray();
                        bVar.bzP.setTag(sparseArray);
                    }
                    if (bVar.bzP.getVisibility() == 0) {
                        sparseArray.put(v.tag_manage_user_identity, Integer.valueOf(this.boL));
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
                sparseArray = (SparseArray) bVar.bzP.getTag();
                if (sparseArray == null) {
                }
                if (bVar.bzP.getVisibility() == 0) {
                }
                if (z4) {
                }
                if (z3) {
                }
            } else {
                if (this.bzM) {
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
                sparseArray = (SparseArray) bVar.bzP.getTag();
                if (sparseArray == null) {
                }
                if (bVar.bzP.getVisibility() == 0) {
                }
                if (z4) {
                }
                if (z3) {
                }
            }
        }
    }
}
