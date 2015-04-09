package com.baidu.tieba.pb.pb.sub;

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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.core.util.bd;
import com.baidu.tbadk.game.GameInfoData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.w;
import com.baidu.tieba.z;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class a extends BaseAdapter {
    protected View.OnClickListener bNq;
    protected Context mContext;
    protected ArrayList<com.baidu.tieba.tbadkCore.c.j> auK = null;
    protected View.OnClickListener bNp = null;
    protected int bNr = 0;
    protected boolean bNs = false;
    protected boolean bJb = false;
    protected boolean bNt = false;
    private boolean mIsFromCDN = true;

    public a(Context context, View.OnClickListener onClickListener) {
        this.mContext = null;
        this.bNq = null;
        this.mContext = context;
        this.bNq = onClickListener;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public int hP(String str) {
        if (this.auK == null) {
            return -1;
        }
        int size = this.auK.size();
        for (int i = 0; i < size; i++) {
            if (this.auK.get(i).getId().equals(str)) {
                return i;
            }
        }
        return -1;
    }

    public void setDatas(ArrayList<com.baidu.tieba.tbadkCore.c.j> arrayList) {
        if (arrayList == null) {
            this.auK = new ArrayList<>();
        } else {
            this.auK = arrayList;
        }
    }

    public void x(View.OnClickListener onClickListener) {
        this.bNp = onClickListener;
    }

    public void q(int i, boolean z) {
        this.bNr = i;
        this.bNs = z;
    }

    public void dI(boolean z) {
        this.bJb = false;
    }

    public void dZ(boolean z) {
        this.bNt = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.auK == null) {
            return 0;
        }
        return this.auK.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.auK == null || i < 0 || i >= this.auK.size()) {
            return null;
        }
        return this.auK.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = mN();
        }
        b bVar = (b) ((SparseArray) view.getTag()).get(com.baidu.tieba.v.tag_holder);
        if (getItem(i) != null) {
            a(bVar, (com.baidu.tieba.tbadkCore.c.j) getItem(i), !(!this.bNt && i + 1 >= getCount()), i == 0);
        }
        return view;
    }

    public View mN() {
        b bVar = new b(this);
        View inflate = com.baidu.adp.lib.g.b.hH().inflate(this.mContext, w.new_sub_pb_list_item, null);
        bVar.rootView = inflate;
        bVar.bNu = (LinearLayout) inflate.findViewById(com.baidu.tieba.v.sub_pb_item_columnlayout);
        bVar.bNv = (TextView) inflate.findViewById(com.baidu.tieba.v.manage_btn);
        bVar.bKu = (TbRichTextView) inflate.findViewById(com.baidu.tieba.v.new_sub_pb_list_richText);
        bVar.bKu.DS();
        bVar.bKu.setLineSpacing(1.0f);
        bVar.bKu.setTextSize(TbConfig.getContentSizeOfLzl(this.mContext));
        bVar.bKu.setTextColor(ba.getColor(com.baidu.tieba.s.gray_day_3));
        bVar.bNv.setOnClickListener(this.bNp);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(com.baidu.tieba.v.tag_holder, bVar);
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
    public void a(b bVar, com.baidu.tieba.tbadkCore.c.j jVar, boolean z, boolean z2) {
        boolean z3;
        boolean z4;
        boolean z5;
        SparseArray sparseArray;
        com.baidu.tbadk.widget.richText.c cVar;
        TextAppearanceSpan textAppearanceSpan;
        if (bVar != null && jVar != null) {
            bVar.bKu.setPadding(0, 0, 0, 0);
            int skinType = TbadkCoreApplication.m411getInst().getSkinType();
            if (jVar.getAuthor() != null) {
                String userName = jVar.getAuthor().getUserName();
                SparseArray sparseArray2 = (SparseArray) bVar.rootView.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    bVar.rootView.setTag(sparseArray2);
                }
                sparseArray2.put(com.baidu.tieba.v.tag_photo_username, userName);
                sparseArray2.put(com.baidu.tieba.v.tag_clip_board, jVar);
                sparseArray2.put(com.baidu.tieba.v.tag_is_subpb, true);
            }
            bVar.bKu.setLinkTextColor(ba.getColor(com.baidu.tieba.s.cp_link_tip_c));
            com.baidu.tbadk.widget.richText.a amQ = jVar.amQ();
            if (amQ != null) {
                ArrayList<com.baidu.tbadk.widget.richText.c> DB = amQ.DB();
                if (DB.size() > 0) {
                    com.baidu.tbadk.widget.richText.c cVar2 = DB.get(DB.size() - 1);
                    int type = cVar2.getType();
                    String str = "";
                    if (type == 1) {
                        str = (DB.size() <= 1 || DB.get(DB.size() + (-2)).getType() == type) ? "  " + bd.n(jVar.getTime()) : bd.n(jVar.getTime());
                        SpannableStringBuilder DH = cVar2.DH();
                        if (amQ.ask) {
                            DH.delete(DH.length() - amQ.asl, DH.length());
                        }
                        DH.append((CharSequence) str);
                        amQ.ask = true;
                        amQ.asl = str.length();
                        cVar = cVar2;
                    } else if (amQ.ask) {
                        cVar = cVar2;
                    } else {
                        str = bd.n(jVar.getTime());
                        com.baidu.tbadk.widget.richText.c cVar3 = new com.baidu.tbadk.widget.richText.c(1);
                        cVar3.append(str);
                        amQ.ask = true;
                        amQ.asl = str.length();
                        DB.add(cVar3);
                        cVar = cVar3;
                    }
                    if (skinType == 1) {
                        textAppearanceSpan = new TextAppearanceSpan(this.mContext, z.subtext_1);
                    } else {
                        textAppearanceSpan = new TextAppearanceSpan(this.mContext, z.subtext);
                    }
                    SpannableStringBuilder DH2 = cVar.DH();
                    DH2.setSpan(textAppearanceSpan, DH2.length() - str.length(), DH2.length(), 33);
                }
                bVar.bKu.setVoiceViewRes(w.voice_play_btn);
                bVar.bKu.setIsFromCDN(this.mIsFromCDN);
                bVar.bKu.setText(jVar.amQ());
            }
            boolean z6 = false;
            boolean z7 = false;
            String userId = jVar.getAuthor().getUserId();
            if (this.bNr != 0) {
                z6 = true;
                z7 = true;
                if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z6 = false;
                }
                if (userId == null || userId.equals(GameInfoData.NOT_FROM_DETAIL) || userId.length() == 0) {
                    z3 = false;
                    z4 = true;
                    z5 = false;
                    if (!z4 && z3) {
                        bVar.bNv.setVisibility(0);
                        bVar.bNv.setCompoundDrawablesWithIntrinsicBounds(ba.getDrawable(com.baidu.tieba.u.icon_floor_manage_n), (Drawable) null, (Drawable) null, (Drawable) null);
                    } else if (z4) {
                        bVar.bNv.setVisibility(0);
                        bVar.bNv.setCompoundDrawablesWithIntrinsicBounds(ba.getDrawable(com.baidu.tieba.u.icon_floor_delete_n), (Drawable) null, (Drawable) null, (Drawable) null);
                    } else {
                        bVar.bNv.setVisibility(8);
                    }
                    sparseArray = (SparseArray) bVar.bNv.getTag();
                    if (sparseArray == null) {
                        sparseArray = new SparseArray();
                        bVar.bNv.setTag(sparseArray);
                    }
                    if (bVar.bNv.getVisibility() == 0) {
                        sparseArray.put(com.baidu.tieba.v.tag_manage_user_identity, Integer.valueOf(this.bNr));
                    }
                    if (z4) {
                        sparseArray.put(com.baidu.tieba.v.tag_del_post_is_self, Boolean.valueOf(z5));
                        sparseArray.put(com.baidu.tieba.v.tag_del_post_type, 2);
                        sparseArray.put(com.baidu.tieba.v.tag_del_post_id, jVar.getId());
                    } else {
                        sparseArray.put(com.baidu.tieba.v.tag_del_post_is_self, Boolean.valueOf(z5));
                        sparseArray.put(com.baidu.tieba.v.tag_del_post_type, 0);
                        sparseArray.put(com.baidu.tieba.v.tag_del_post_id, "");
                    }
                    if (z3) {
                        sparseArray.put(com.baidu.tieba.v.tag_forbid_user_name, jVar.getAuthor().getUserName());
                        sparseArray.put(com.baidu.tieba.v.tag_forbid_user_post_id, jVar.getId());
                        return;
                    }
                    sparseArray.put(com.baidu.tieba.v.tag_forbid_user_name, "");
                    return;
                }
                z3 = z6;
                z4 = z7;
                z5 = false;
                if (!z4) {
                }
                if (z4) {
                }
                sparseArray = (SparseArray) bVar.bNv.getTag();
                if (sparseArray == null) {
                }
                if (bVar.bNv.getVisibility() == 0) {
                }
                if (z4) {
                }
                if (z3) {
                }
            } else {
                if (this.bNs) {
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
                sparseArray = (SparseArray) bVar.bNv.getTag();
                if (sparseArray == null) {
                }
                if (bVar.bNv.getVisibility() == 0) {
                }
                if (z4) {
                }
                if (z3) {
                }
            }
        }
    }
}
