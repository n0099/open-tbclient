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
    protected View.OnClickListener bFu;
    protected Context mContext;
    protected ArrayList<com.baidu.tieba.tbadkCore.b.k> amP = null;
    protected View.OnClickListener bFt = null;
    protected int bFv = 0;
    protected boolean bFw = false;
    protected boolean bBj = false;
    protected boolean bFx = false;
    private boolean mIsFromCDN = true;

    public a(Context context, View.OnClickListener onClickListener) {
        this.mContext = null;
        this.bFu = null;
        this.mContext = context;
        this.bFu = onClickListener;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public int hF(String str) {
        if (this.amP == null) {
            return -1;
        }
        int size = this.amP.size();
        for (int i = 0; i < size; i++) {
            if (this.amP.get(i).getId().equals(str)) {
                return i;
            }
        }
        return -1;
    }

    public void setDatas(ArrayList<com.baidu.tieba.tbadkCore.b.k> arrayList) {
        if (arrayList == null) {
            this.amP = new ArrayList<>();
        } else {
            this.amP = arrayList;
        }
    }

    public void B(View.OnClickListener onClickListener) {
        this.bFt = onClickListener;
    }

    public void u(int i, boolean z) {
        this.bFv = i;
        this.bFw = z;
    }

    public void dP(boolean z) {
        this.bBj = false;
    }

    public void ee(boolean z) {
        this.bFx = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.amP == null) {
            return 0;
        }
        return this.amP.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.amP == null || i < 0 || i >= this.amP.size()) {
            return null;
        }
        return this.amP.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = jy();
        }
        b bVar = (b) ((SparseArray) view.getTag()).get(w.tag_holder);
        if (getItem(i) != null) {
            a(bVar, (com.baidu.tieba.tbadkCore.b.k) getItem(i), !(!this.bFx && i + 1 >= getCount()), i == 0);
        }
        return view;
    }

    public View jy() {
        b bVar = new b(this);
        View inflate = com.baidu.adp.lib.g.b.ei().inflate(this.mContext, x.new_sub_pb_list_item, null);
        bVar.rootView = inflate;
        bVar.bFy = (LinearLayout) inflate.findViewById(w.sub_pb_item_columnlayout);
        bVar.bFz = (TextView) inflate.findViewById(w.manage_btn);
        bVar.bBJ = (TbRichTextView) inflate.findViewById(w.new_sub_pb_list_richText);
        bVar.bBJ.setTextSize(TbConfig.getContentSizeOfLzl(this.mContext));
        bVar.bBJ.setTextColor(bc.getColor(t.gray_day_3));
        bVar.bFz.setOnClickListener(this.bFt);
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
            bVar.bBJ.setPadding(0, 0, 0, 0);
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
            bVar.bBJ.setLinkTextColor(bc.getColor(t.cp_link_tip_c));
            com.baidu.tbadk.widget.richText.a ahz = kVar.ahz();
            if (ahz != null) {
                ArrayList<com.baidu.tbadk.widget.richText.c> Af = ahz.Af();
                if (Af.size() > 0) {
                    com.baidu.tbadk.widget.richText.c cVar2 = Af.get(Af.size() - 1);
                    int type = cVar2.getType();
                    String str = "";
                    if (type == 1) {
                        str = (Af.size() <= 1 || Af.get(Af.size() + (-2)).getType() == type) ? "  " + bf.n(kVar.getTime()) : bf.n(kVar.getTime());
                        SpannableStringBuilder Al = cVar2.Al();
                        if (ahz.ajG) {
                            Al.delete(Al.length() - ahz.ajH, Al.length());
                        }
                        Al.append((CharSequence) str);
                        ahz.ajG = true;
                        ahz.ajH = str.length();
                        cVar = cVar2;
                    } else if (ahz.ajG) {
                        cVar = cVar2;
                    } else {
                        str = bf.n(kVar.getTime());
                        com.baidu.tbadk.widget.richText.c cVar3 = new com.baidu.tbadk.widget.richText.c(1);
                        cVar3.append(str);
                        ahz.ajG = true;
                        ahz.ajH = str.length();
                        Af.add(cVar3);
                        cVar = cVar3;
                    }
                    if (skinType == 1) {
                        textAppearanceSpan = new TextAppearanceSpan(this.mContext, aa.subtext_1);
                    } else {
                        textAppearanceSpan = new TextAppearanceSpan(this.mContext, aa.subtext);
                    }
                    SpannableStringBuilder Al2 = cVar.Al();
                    Al2.setSpan(textAppearanceSpan, Al2.length() - str.length(), Al2.length(), 33);
                }
                bVar.bBJ.setVoiceViewRes(x.voice_play_btn);
                bVar.bBJ.setIsFromCDN(this.mIsFromCDN);
                bVar.bBJ.setText(kVar.ahz());
            }
            boolean z6 = false;
            boolean z7 = false;
            String userId = kVar.getAuthor().getUserId();
            if (this.bFv != 0) {
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
                        bVar.bFz.setVisibility(0);
                        bVar.bFz.setCompoundDrawablesWithIntrinsicBounds(bc.getDrawable(v.icon_floor_manage_n), (Drawable) null, (Drawable) null, (Drawable) null);
                    } else if (z4) {
                        bVar.bFz.setVisibility(0);
                        bVar.bFz.setCompoundDrawablesWithIntrinsicBounds(bc.getDrawable(v.icon_floor_delete_n), (Drawable) null, (Drawable) null, (Drawable) null);
                    } else {
                        bVar.bFz.setVisibility(8);
                    }
                    sparseArray = (SparseArray) bVar.bFz.getTag();
                    if (sparseArray == null) {
                        sparseArray = new SparseArray();
                        bVar.bFz.setTag(sparseArray);
                    }
                    if (bVar.bFz.getVisibility() == 0) {
                        sparseArray.put(w.tag_manage_user_identity, Integer.valueOf(this.bFv));
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
                sparseArray = (SparseArray) bVar.bFz.getTag();
                if (sparseArray == null) {
                }
                if (bVar.bFz.getVisibility() == 0) {
                }
                if (z4) {
                }
                if (z3) {
                }
            } else {
                if (this.bFw) {
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
                sparseArray = (SparseArray) bVar.bFz.getTag();
                if (sparseArray == null) {
                }
                if (bVar.bFz.getVisibility() == 0) {
                }
                if (z4) {
                }
                if (z3) {
                }
            }
        }
    }
}
