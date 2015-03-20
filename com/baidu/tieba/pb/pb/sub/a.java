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
    protected View.OnClickListener bNa;
    protected Context mContext;
    protected ArrayList<com.baidu.tieba.tbadkCore.c.j> auC = null;
    protected View.OnClickListener bMZ = null;
    protected int bNb = 0;
    protected boolean bNc = false;
    protected boolean bIN = false;
    protected boolean bNd = false;
    private boolean mIsFromCDN = true;

    public a(Context context, View.OnClickListener onClickListener) {
        this.mContext = null;
        this.bNa = null;
        this.mContext = context;
        this.bNa = onClickListener;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public int hM(String str) {
        if (this.auC == null) {
            return -1;
        }
        int size = this.auC.size();
        for (int i = 0; i < size; i++) {
            if (this.auC.get(i).getId().equals(str)) {
                return i;
            }
        }
        return -1;
    }

    public void setDatas(ArrayList<com.baidu.tieba.tbadkCore.c.j> arrayList) {
        if (arrayList == null) {
            this.auC = new ArrayList<>();
        } else {
            this.auC = arrayList;
        }
    }

    public void w(View.OnClickListener onClickListener) {
        this.bMZ = onClickListener;
    }

    public void q(int i, boolean z) {
        this.bNb = i;
        this.bNc = z;
    }

    public void dK(boolean z) {
        this.bIN = false;
    }

    public void eb(boolean z) {
        this.bNd = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.auC == null) {
            return 0;
        }
        return this.auC.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.auC == null || i < 0 || i >= this.auC.size()) {
            return null;
        }
        return this.auC.get(i);
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
            a(bVar, (com.baidu.tieba.tbadkCore.c.j) getItem(i), !(!this.bNd && i + 1 >= getCount()), i == 0);
        }
        return view;
    }

    public View mN() {
        b bVar = new b(this);
        View inflate = com.baidu.adp.lib.g.b.hH().inflate(this.mContext, w.new_sub_pb_list_item, null);
        bVar.rootView = inflate;
        bVar.bNe = (LinearLayout) inflate.findViewById(com.baidu.tieba.v.sub_pb_item_columnlayout);
        bVar.bNf = (TextView) inflate.findViewById(com.baidu.tieba.v.manage_btn);
        bVar.bKf = (TbRichTextView) inflate.findViewById(com.baidu.tieba.v.new_sub_pb_list_richText);
        bVar.bKf.DM();
        bVar.bKf.setLineSpacing(1.0f);
        bVar.bKf.setTextSize(TbConfig.getContentSizeOfLzl(this.mContext));
        bVar.bKf.setTextColor(ba.getColor(com.baidu.tieba.s.gray_day_3));
        bVar.bNf.setOnClickListener(this.bMZ);
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
            bVar.bKf.setPadding(0, 0, 0, 0);
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
            bVar.bKf.setLinkTextColor(ba.getColor(com.baidu.tieba.s.cp_link_tip_c));
            com.baidu.tbadk.widget.richText.a amB = jVar.amB();
            if (amB != null) {
                ArrayList<com.baidu.tbadk.widget.richText.c> Dv = amB.Dv();
                if (Dv.size() > 0) {
                    com.baidu.tbadk.widget.richText.c cVar2 = Dv.get(Dv.size() - 1);
                    int type = cVar2.getType();
                    String str = "";
                    if (type == 1) {
                        str = (Dv.size() <= 1 || Dv.get(Dv.size() + (-2)).getType() == type) ? "  " + bd.n(jVar.getTime()) : bd.n(jVar.getTime());
                        SpannableStringBuilder DB = cVar2.DB();
                        if (amB.asc) {
                            DB.delete(DB.length() - amB.asd, DB.length());
                        }
                        DB.append((CharSequence) str);
                        amB.asc = true;
                        amB.asd = str.length();
                        cVar = cVar2;
                    } else if (amB.asc) {
                        cVar = cVar2;
                    } else {
                        str = bd.n(jVar.getTime());
                        com.baidu.tbadk.widget.richText.c cVar3 = new com.baidu.tbadk.widget.richText.c(1);
                        cVar3.append(str);
                        amB.asc = true;
                        amB.asd = str.length();
                        Dv.add(cVar3);
                        cVar = cVar3;
                    }
                    if (skinType == 1) {
                        textAppearanceSpan = new TextAppearanceSpan(this.mContext, z.subtext_1);
                    } else {
                        textAppearanceSpan = new TextAppearanceSpan(this.mContext, z.subtext);
                    }
                    SpannableStringBuilder DB2 = cVar.DB();
                    DB2.setSpan(textAppearanceSpan, DB2.length() - str.length(), DB2.length(), 33);
                }
                bVar.bKf.setVoiceViewRes(w.voice_play_btn);
                bVar.bKf.setIsFromCDN(this.mIsFromCDN);
                bVar.bKf.setText(jVar.amB());
            }
            boolean z6 = false;
            boolean z7 = false;
            String userId = jVar.getAuthor().getUserId();
            if (this.bNb != 0) {
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
                        bVar.bNf.setVisibility(0);
                        bVar.bNf.setCompoundDrawablesWithIntrinsicBounds(ba.getDrawable(com.baidu.tieba.u.icon_floor_manage_n), (Drawable) null, (Drawable) null, (Drawable) null);
                    } else if (z4) {
                        bVar.bNf.setVisibility(0);
                        bVar.bNf.setCompoundDrawablesWithIntrinsicBounds(ba.getDrawable(com.baidu.tieba.u.icon_floor_delete_n), (Drawable) null, (Drawable) null, (Drawable) null);
                    } else {
                        bVar.bNf.setVisibility(8);
                    }
                    sparseArray = (SparseArray) bVar.bNf.getTag();
                    if (sparseArray == null) {
                        sparseArray = new SparseArray();
                        bVar.bNf.setTag(sparseArray);
                    }
                    if (bVar.bNf.getVisibility() == 0) {
                        sparseArray.put(com.baidu.tieba.v.tag_manage_user_identity, Integer.valueOf(this.bNb));
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
                sparseArray = (SparseArray) bVar.bNf.getTag();
                if (sparseArray == null) {
                }
                if (bVar.bNf.getVisibility() == 0) {
                }
                if (z4) {
                }
                if (z3) {
                }
            } else {
                if (this.bNc) {
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
                sparseArray = (SparseArray) bVar.bNf.getTag();
                if (sparseArray == null) {
                }
                if (bVar.bNf.getVisibility() == 0) {
                }
                if (z4) {
                }
                if (z3) {
                }
            }
        }
    }
}
