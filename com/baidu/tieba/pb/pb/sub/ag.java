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
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.core.util.bb;
import com.baidu.tbadk.game.GameInfoData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ag extends BaseAdapter {
    protected Context mContext;
    protected ArrayList<com.baidu.tieba.tbadkCore.data.j> Sk = null;
    protected View.OnClickListener bPX = null;
    protected int bPY = 0;
    protected boolean bPZ = false;
    protected boolean bLi = false;
    protected boolean bQa = false;
    private boolean mIsFromCDN = true;

    public ag(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public int ix(String str) {
        if (this.Sk == null) {
            return -1;
        }
        int size = this.Sk.size();
        for (int i = 0; i < size; i++) {
            if (this.Sk.get(i).getId().equals(str)) {
                return i;
            }
        }
        return -1;
    }

    public void setDatas(ArrayList<com.baidu.tieba.tbadkCore.data.j> arrayList) {
        if (arrayList == null) {
            this.Sk = new ArrayList<>();
        } else {
            this.Sk = arrayList;
        }
    }

    public void w(View.OnClickListener onClickListener) {
        this.bPX = onClickListener;
    }

    public void p(int i, boolean z) {
        this.bPY = i;
        this.bPZ = z;
    }

    public void dT(boolean z) {
        this.bLi = false;
    }

    public void em(boolean z) {
        this.bQa = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.Sk == null) {
            return 0;
        }
        return this.Sk.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.Sk == null || i < 0 || i >= this.Sk.size()) {
            return null;
        }
        return this.Sk.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = ng();
        }
        ah ahVar = (ah) ((SparseArray) view.getTag()).get(com.baidu.tieba.q.tag_holder);
        if (getItem(i) != null) {
            a(ahVar, (com.baidu.tieba.tbadkCore.data.j) getItem(i), !(!this.bQa && i + 1 >= getCount()), i == 0);
        }
        return view;
    }

    public View ng() {
        ah ahVar = new ah(this);
        View inflate = com.baidu.adp.lib.g.b.hr().inflate(this.mContext, com.baidu.tieba.r.new_sub_pb_list_item, null);
        ahVar.rootView = inflate;
        ahVar.bQb = (LinearLayout) inflate.findViewById(com.baidu.tieba.q.sub_pb_item_columnlayout);
        ahVar.bQc = (TextView) inflate.findViewById(com.baidu.tieba.q.manage_btn);
        ahVar.bMB = (TbRichTextView) inflate.findViewById(com.baidu.tieba.q.new_sub_pb_list_richText);
        ahVar.bMB.ED();
        ahVar.bMB.setLineSpacing(1.0f);
        ahVar.bMB.setTextSize(TbConfig.getContentSizeOfLzl(this.mContext));
        ahVar.bMB.setTextColor(ay.getColor(com.baidu.tieba.n.gray_day_3));
        ahVar.bQc.setOnClickListener(this.bPX);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(com.baidu.tieba.q.tag_holder, ahVar);
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
    public void a(ah ahVar, com.baidu.tieba.tbadkCore.data.j jVar, boolean z, boolean z2) {
        boolean z3;
        boolean z4;
        boolean z5;
        SparseArray sparseArray;
        com.baidu.tbadk.widget.richText.c cVar;
        TextAppearanceSpan textAppearanceSpan;
        if (ahVar != null && jVar != null) {
            ahVar.bMB.setPadding(0, 0, 0, 0);
            int skinType = TbadkCoreApplication.m411getInst().getSkinType();
            if (jVar.getAuthor() != null) {
                String userName = jVar.getAuthor().getUserName();
                SparseArray sparseArray2 = (SparseArray) ahVar.rootView.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    ahVar.rootView.setTag(sparseArray2);
                }
                sparseArray2.put(com.baidu.tieba.q.tag_photo_username, userName);
                sparseArray2.put(com.baidu.tieba.q.tag_clip_board, jVar);
                sparseArray2.put(com.baidu.tieba.q.tag_is_subpb, true);
            }
            ahVar.bMB.setLinkTextColor(ay.getColor(com.baidu.tieba.n.cp_link_tip_c));
            com.baidu.tbadk.widget.richText.a aoD = jVar.aoD();
            if (aoD != null) {
                ArrayList<com.baidu.tbadk.widget.richText.c> Em = aoD.Em();
                if (Em.size() > 0) {
                    com.baidu.tbadk.widget.richText.c cVar2 = Em.get(Em.size() - 1);
                    int type = cVar2.getType();
                    String str = "";
                    if (type == 1) {
                        str = (Em.size() <= 1 || Em.get(Em.size() + (-2)).getType() == type) ? "  " + bb.o(jVar.getTime()) : bb.o(jVar.getTime());
                        SpannableStringBuilder Es = cVar2.Es();
                        if (aoD.atO) {
                            Es.delete(Es.length() - aoD.atP, Es.length());
                        }
                        Es.append((CharSequence) str);
                        aoD.atO = true;
                        aoD.atP = str.length();
                        cVar = cVar2;
                    } else if (aoD.atO) {
                        cVar = cVar2;
                    } else {
                        str = bb.o(jVar.getTime());
                        com.baidu.tbadk.widget.richText.c cVar3 = new com.baidu.tbadk.widget.richText.c(1);
                        cVar3.append(str);
                        aoD.atO = true;
                        aoD.atP = str.length();
                        Em.add(cVar3);
                        cVar = cVar3;
                    }
                    if (skinType == 1) {
                        textAppearanceSpan = new TextAppearanceSpan(this.mContext, com.baidu.tieba.u.subtext_1);
                    } else {
                        textAppearanceSpan = new TextAppearanceSpan(this.mContext, com.baidu.tieba.u.subtext);
                    }
                    SpannableStringBuilder Es2 = cVar.Es();
                    Es2.setSpan(textAppearanceSpan, Es2.length() - str.length(), Es2.length(), 33);
                }
                ahVar.bMB.setVoiceViewRes(com.baidu.tieba.r.voice_play_btn);
                ahVar.bMB.setIsFromCDN(this.mIsFromCDN);
                ahVar.bMB.setText(jVar.aoD());
            }
            boolean z6 = false;
            boolean z7 = false;
            String userId = jVar.getAuthor().getUserId();
            if (this.bPY != 0) {
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
                        ahVar.bQc.setVisibility(0);
                        ahVar.bQc.setCompoundDrawablesWithIntrinsicBounds(ay.getDrawable(com.baidu.tieba.p.icon_floor_manage_n), (Drawable) null, (Drawable) null, (Drawable) null);
                    } else if (z4) {
                        ahVar.bQc.setVisibility(0);
                        ahVar.bQc.setCompoundDrawablesWithIntrinsicBounds(ay.getDrawable(com.baidu.tieba.p.icon_floor_delete_n), (Drawable) null, (Drawable) null, (Drawable) null);
                    } else {
                        ahVar.bQc.setVisibility(8);
                    }
                    sparseArray = (SparseArray) ahVar.bQc.getTag();
                    if (sparseArray == null) {
                        sparseArray = new SparseArray();
                        ahVar.bQc.setTag(sparseArray);
                    }
                    if (ahVar.bQc.getVisibility() == 0) {
                        sparseArray.put(com.baidu.tieba.q.tag_manage_user_identity, Integer.valueOf(this.bPY));
                    }
                    if (z4) {
                        sparseArray.put(com.baidu.tieba.q.tag_del_post_is_self, Boolean.valueOf(z5));
                        sparseArray.put(com.baidu.tieba.q.tag_del_post_type, 2);
                        sparseArray.put(com.baidu.tieba.q.tag_del_post_id, jVar.getId());
                    } else {
                        sparseArray.put(com.baidu.tieba.q.tag_del_post_is_self, Boolean.valueOf(z5));
                        sparseArray.put(com.baidu.tieba.q.tag_del_post_type, 0);
                        sparseArray.put(com.baidu.tieba.q.tag_del_post_id, "");
                    }
                    if (z3) {
                        sparseArray.put(com.baidu.tieba.q.tag_forbid_user_name, jVar.getAuthor().getUserName());
                        sparseArray.put(com.baidu.tieba.q.tag_forbid_user_post_id, jVar.getId());
                        return;
                    }
                    sparseArray.put(com.baidu.tieba.q.tag_forbid_user_name, "");
                    return;
                }
                z3 = z6;
                z4 = z7;
                z5 = false;
                if (!z4) {
                }
                if (z4) {
                }
                sparseArray = (SparseArray) ahVar.bQc.getTag();
                if (sparseArray == null) {
                }
                if (ahVar.bQc.getVisibility() == 0) {
                }
                if (z4) {
                }
                if (z3) {
                }
            } else {
                if (this.bPZ) {
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
                sparseArray = (SparseArray) ahVar.bQc.getTag();
                if (sparseArray == null) {
                }
                if (ahVar.bQc.getVisibility() == 0) {
                }
                if (z4) {
                }
                if (z3) {
                }
            }
        }
    }
}
