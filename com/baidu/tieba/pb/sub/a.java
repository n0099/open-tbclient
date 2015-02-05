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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.aa;
import com.baidu.tieba.t;
import com.baidu.tieba.v;
import com.baidu.tieba.w;
import com.baidu.tieba.x;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends BaseAdapter {
    protected View.OnClickListener bFt;
    protected Context mContext;
    protected ArrayList<com.baidu.tieba.tbadkCore.b.k> amM = null;
    protected View.OnClickListener bFs = null;
    protected int bFu = 0;
    protected boolean bFv = false;
    protected boolean bBi = false;
    protected boolean bFw = false;
    private boolean mIsFromCDN = true;

    public a(Context context, View.OnClickListener onClickListener) {
        this.mContext = null;
        this.bFt = null;
        this.mContext = context;
        this.bFt = onClickListener;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public int hC(String str) {
        if (this.amM == null) {
            return -1;
        }
        int size = this.amM.size();
        for (int i = 0; i < size; i++) {
            if (this.amM.get(i).getId().equals(str)) {
                return i;
            }
        }
        return -1;
    }

    public void setDatas(ArrayList<com.baidu.tieba.tbadkCore.b.k> arrayList) {
        if (arrayList == null) {
            this.amM = new ArrayList<>();
        } else {
            this.amM = arrayList;
        }
    }

    public void B(View.OnClickListener onClickListener) {
        this.bFs = onClickListener;
    }

    public void u(int i, boolean z) {
        this.bFu = i;
        this.bFv = z;
    }

    public void dP(boolean z) {
        this.bBi = false;
    }

    public void ee(boolean z) {
        this.bFw = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.amM == null) {
            return 0;
        }
        return this.amM.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.amM == null || i < 0 || i >= this.amM.size()) {
            return null;
        }
        return this.amM.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = jr();
        }
        b bVar = (b) ((SparseArray) view.getTag()).get(w.tag_holder);
        if (getItem(i) != null) {
            a(bVar, (com.baidu.tieba.tbadkCore.b.k) getItem(i), !(!this.bFw && i + 1 >= getCount()), i == 0);
        }
        return view;
    }

    public View jr() {
        b bVar = new b(this);
        View inflate = com.baidu.adp.lib.g.b.ei().inflate(this.mContext, x.new_sub_pb_list_item, null);
        bVar.rootView = inflate;
        bVar.bFx = (LinearLayout) inflate.findViewById(w.sub_pb_item_columnlayout);
        bVar.bFy = (TextView) inflate.findViewById(w.manage_btn);
        bVar.bBI = (TbRichTextView) inflate.findViewById(w.new_sub_pb_list_richText);
        bVar.bBI.setTextSize(TbConfig.getContentSizeOfLzl(this.mContext));
        bVar.bBI.setTextColor(bc.getColor(t.gray_day_3));
        bVar.bFy.setOnClickListener(this.bFs);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(w.tag_holder, bVar);
        inflate.setTag(sparseArray);
        return inflate;
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x0145 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x01a2  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0245  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(b bVar, com.baidu.tieba.tbadkCore.b.k kVar, boolean z, boolean z2) {
        boolean z3;
        boolean z4;
        boolean z5;
        SparseArray sparseArray;
        com.baidu.tbadk.widget.richText.c cVar;
        TextAppearanceSpan textAppearanceSpan;
        if (bVar != null && kVar != null) {
            bVar.bBI.setPadding(0, 0, 0, 0);
            int skinType = TbadkCoreApplication.m255getInst().getSkinType();
            if (kVar.getAuthor() != null) {
                String userName = kVar.getAuthor().getUserName();
                SparseArray sparseArray2 = (SparseArray) bVar.rootView.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    bVar.rootView.setTag(sparseArray2);
                }
                sparseArray2.put(w.tag_photo_username, userName);
                sparseArray2.put(w.tag_clip_board, kVar);
                sparseArray2.put(w.tag_is_subpb, true);
            }
            bVar.bBI.setLinkTextColor(bc.getColor(t.cp_link_tip_c));
            com.baidu.tbadk.widget.richText.a ahu = kVar.ahu();
            if (ahu != null) {
                ArrayList<com.baidu.tbadk.widget.richText.c> zZ = ahu.zZ();
                if (zZ.size() > 0) {
                    com.baidu.tbadk.widget.richText.c cVar2 = zZ.get(zZ.size() - 1);
                    int type = cVar2.getType();
                    String str = "";
                    if (type == 1) {
                        str = (zZ.size() <= 1 || zZ.get(zZ.size() + (-2)).getType() == type) ? "  " + bf.n(kVar.getTime()) : bf.n(kVar.getTime());
                        SpannableStringBuilder Af = cVar2.Af();
                        if (ahu.ajD) {
                            Af.delete(Af.length() - ahu.ajE, Af.length());
                        }
                        Af.append((CharSequence) str);
                        ahu.ajD = true;
                        ahu.ajE = str.length();
                        cVar = cVar2;
                    } else if (ahu.ajD) {
                        cVar = cVar2;
                    } else {
                        str = bf.n(kVar.getTime());
                        com.baidu.tbadk.widget.richText.c cVar3 = new com.baidu.tbadk.widget.richText.c(1);
                        cVar3.append(str);
                        ahu.ajD = true;
                        ahu.ajE = str.length();
                        zZ.add(cVar3);
                        cVar = cVar3;
                    }
                    if (skinType == 1) {
                        textAppearanceSpan = new TextAppearanceSpan(this.mContext, aa.subtext_1);
                    } else {
                        textAppearanceSpan = new TextAppearanceSpan(this.mContext, aa.subtext);
                    }
                    SpannableStringBuilder Af2 = cVar.Af();
                    Af2.setSpan(textAppearanceSpan, Af2.length() - str.length(), Af2.length(), 33);
                }
                bVar.bBI.setVoiceViewRes(x.voice_play_btn);
                bVar.bBI.setIsFromCDN(this.mIsFromCDN);
                bVar.bBI.setText(kVar.ahu());
            }
            boolean z6 = false;
            boolean z7 = false;
            String userId = kVar.getAuthor().getUserId();
            if (this.bFu != 0) {
                z6 = true;
                z7 = true;
                if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z6 = false;
                }
                if (userId == null || userId.equals("0") || userId.length() == 0) {
                    z3 = false;
                    z4 = true;
                    z5 = false;
                    if (!z4 && z3) {
                        bVar.bFy.setVisibility(0);
                        bVar.bFy.setCompoundDrawablesWithIntrinsicBounds(bc.getDrawable(v.icon_floor_manage_n), (Drawable) null, (Drawable) null, (Drawable) null);
                    } else if (z4) {
                        bVar.bFy.setVisibility(0);
                        bVar.bFy.setCompoundDrawablesWithIntrinsicBounds(bc.getDrawable(v.icon_floor_delete_n), (Drawable) null, (Drawable) null, (Drawable) null);
                    } else {
                        bVar.bFy.setVisibility(8);
                    }
                    sparseArray = (SparseArray) bVar.bFy.getTag();
                    if (sparseArray == null) {
                        sparseArray = new SparseArray();
                        bVar.bFy.setTag(sparseArray);
                    }
                    if (bVar.bFy.getVisibility() == 0) {
                        sparseArray.put(w.tag_manage_user_identity, Integer.valueOf(this.bFu));
                    }
                    if (z4) {
                        sparseArray.put(w.tag_del_post_is_self, Boolean.valueOf(z5));
                        sparseArray.put(w.tag_del_post_type, 2);
                        sparseArray.put(w.tag_del_post_id, kVar.getId());
                    } else {
                        sparseArray.put(w.tag_del_post_is_self, Boolean.valueOf(z5));
                        sparseArray.put(w.tag_del_post_type, 0);
                        sparseArray.put(w.tag_del_post_id, "");
                    }
                    if (z3) {
                        sparseArray.put(w.tag_forbid_user_name, kVar.getAuthor().getUserName());
                        sparseArray.put(w.tag_forbid_user_post_id, kVar.getId());
                        return;
                    }
                    sparseArray.put(w.tag_forbid_user_name, "");
                    return;
                }
                z3 = z6;
                z4 = z7;
                z5 = false;
                if (!z4) {
                }
                if (z4) {
                }
                sparseArray = (SparseArray) bVar.bFy.getTag();
                if (sparseArray == null) {
                }
                if (bVar.bFy.getVisibility() == 0) {
                }
                if (z4) {
                }
                if (z3) {
                }
            } else {
                if (this.bFv) {
                    z3 = false;
                    z4 = true;
                    z5 = false;
                } else {
                    if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
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
                sparseArray = (SparseArray) bVar.bFy.getTag();
                if (sparseArray == null) {
                }
                if (bVar.bFy.getVisibility() == 0) {
                }
                if (z4) {
                }
                if (z3) {
                }
            }
        }
    }
}
