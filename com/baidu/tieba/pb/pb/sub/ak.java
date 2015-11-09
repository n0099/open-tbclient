package com.baidu.tieba.pb.pb.sub;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.style.TextAppearanceSpan;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.i;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class ak extends BaseAdapter {
    private com.baidu.tbadk.core.data.w aUg;
    protected Context mContext;
    protected ArrayList<com.baidu.tieba.tbadkCore.data.o> Xk = null;
    protected View.OnClickListener cos = null;
    protected int cot = 0;
    protected boolean cou = false;
    protected boolean chO = false;
    protected boolean cov = false;
    private boolean mIsFromCDN = true;

    public ak(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public int jY(String str) {
        if (this.Xk == null) {
            return -1;
        }
        int size = this.Xk.size();
        for (int i = 0; i < size; i++) {
            if (this.Xk.get(i).getId().equals(str)) {
                return i;
            }
        }
        return -1;
    }

    public void e(com.baidu.tbadk.core.data.w wVar) {
        this.aUg = wVar;
    }

    public void setDatas(ArrayList<com.baidu.tieba.tbadkCore.data.o> arrayList) {
        if (arrayList == null) {
            this.Xk = new ArrayList<>();
        } else {
            this.Xk = arrayList;
        }
    }

    public void D(View.OnClickListener onClickListener) {
        this.cos = onClickListener;
    }

    public void p(int i, boolean z) {
        this.cot = i;
        this.cou = z;
    }

    public void et(boolean z) {
        this.chO = false;
    }

    public void setHasMoreData(boolean z) {
        this.cov = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.Xk == null) {
            return 0;
        }
        return this.Xk.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.Xk == null || i < 0 || i >= this.Xk.size()) {
            return null;
        }
        return this.Xk.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = np();
        }
        a aVar = (a) ((SparseArray) view.getTag()).get(i.f.tag_holder);
        if (getItem(i) != null) {
            a(aVar, (com.baidu.tieba.tbadkCore.data.o) getItem(i), !(!this.cov && i + 1 >= getCount()), i == 0);
        }
        return view;
    }

    /* loaded from: classes.dex */
    public class a {
        public TbRichTextView chB;
        public LinearLayout cow;
        public TextView cox;
        public View rootView;

        public a() {
        }
    }

    public View np() {
        a aVar = new a();
        View inflate = LayoutInflater.from(this.mContext).inflate(i.g.new_sub_pb_list_item, (ViewGroup) null);
        aVar.rootView = inflate;
        aVar.cow = (LinearLayout) inflate.findViewById(i.f.sub_pb_item_columnlayout);
        aVar.cox = (TextView) inflate.findViewById(i.f.manage_btn);
        aVar.chB = (TbRichTextView) inflate.findViewById(i.f.new_sub_pb_list_richText);
        aVar.chB.Fj();
        aVar.chB.setLineSpacing(1.0f);
        aVar.chB.setTextSize(TbConfig.getContentSizeOfLzl(this.mContext));
        aVar.chB.setTextColor(com.baidu.tbadk.core.util.an.getColor(i.c.gray_day_3));
        aVar.cox.setOnClickListener(this.cos);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(i.f.tag_holder, aVar);
        inflate.setTag(sparseArray);
        return inflate;
    }

    public void a(a aVar, com.baidu.tieba.tbadkCore.data.o oVar, boolean z, boolean z2) {
        boolean z3;
        boolean z4;
        com.baidu.tbadk.widget.richText.c cVar;
        TextAppearanceSpan textAppearanceSpan;
        if (aVar != null && oVar != null) {
            aVar.chB.setPadding(0, 0, 0, 0);
            int skinType = TbadkCoreApplication.m411getInst().getSkinType();
            if (oVar.getAuthor() != null) {
                String userName = oVar.getAuthor().getUserName();
                SparseArray sparseArray = (SparseArray) aVar.rootView.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    aVar.rootView.setTag(sparseArray);
                }
                sparseArray.put(i.f.tag_photo_username, userName);
                sparseArray.put(i.f.tag_clip_board, oVar);
                sparseArray.put(i.f.tag_is_subpb, true);
            }
            aVar.chB.setLinkTextColor(com.baidu.tbadk.core.util.an.getColor(i.c.cp_link_tip_c));
            com.baidu.tbadk.widget.richText.a axu = oVar.axu();
            if (axu != null) {
                ArrayList<com.baidu.tbadk.widget.richText.c> EI = axu.EI();
                if (EI.size() > 0) {
                    com.baidu.tbadk.widget.richText.c cVar2 = EI.get(EI.size() - 1);
                    int type = cVar2.getType();
                    String str = "";
                    if (type == 1) {
                        String m = (EI.size() <= 1 || EI.get(EI.size() + (-2)).getType() == type) ? "  " + as.m(oVar.getTime()) : as.m(oVar.getTime());
                        SpannableStringBuilder EO = cVar2.EO();
                        if (axu.aAb) {
                            EO.delete(EO.length() - axu.aAc, EO.length());
                        }
                        str = as.dm(m);
                        EO.append((CharSequence) str);
                        axu.aAb = true;
                        axu.aAc = str.length();
                        cVar = cVar2;
                    } else if (axu.aAb) {
                        cVar = cVar2;
                    } else {
                        String m2 = as.m(oVar.getTime());
                        com.baidu.tbadk.widget.richText.c cVar3 = new com.baidu.tbadk.widget.richText.c(1);
                        String dm = as.dm(m2);
                        cVar3.append(dm);
                        axu.aAb = true;
                        axu.aAc = dm.length();
                        EI.add(cVar3);
                        cVar = cVar3;
                        str = dm;
                    }
                    if (skinType == 1) {
                        textAppearanceSpan = new TextAppearanceSpan(this.mContext, i.C0057i.subtext_1);
                    } else {
                        textAppearanceSpan = new TextAppearanceSpan(this.mContext, i.C0057i.subtext);
                    }
                    SpannableStringBuilder EO2 = cVar.EO();
                    EO2.setSpan(textAppearanceSpan, EO2.length() - str.length(), EO2.length(), 33);
                }
                aVar.chB.setVoiceViewRes(i.g.voice_play_btn);
                aVar.chB.setIsFromCDN(this.mIsFromCDN);
                aVar.chB.setText(oVar.axu());
            }
            boolean z5 = false;
            boolean z6 = false;
            boolean z7 = false;
            String userId = oVar.getAuthor().getUserId();
            if (this.cot != 0) {
                z5 = true;
                z6 = true;
                if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z5 = false;
                }
                if (userId == null || userId.equals("0") || userId.length() == 0) {
                    z5 = false;
                }
            }
            if (!this.cou) {
                z3 = false;
            } else if (userId == null || !userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                z3 = true;
                z6 = true;
            } else {
                z3 = false;
                z6 = true;
            }
            if (userId == null || !userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                z4 = z6;
            } else {
                z4 = true;
                z7 = true;
            }
            if (z5) {
                aVar.cox.setVisibility(0);
                aVar.cox.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.an.getDrawable(i.e.icon_floor_manage_n), (Drawable) null, (Drawable) null, (Drawable) null);
            } else if (z3) {
                aVar.cox.setVisibility(0);
                aVar.cox.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.an.getDrawable(i.e.icon_pb_louzhonglou_gag), (Drawable) null, (Drawable) null, (Drawable) null);
            } else if (z4) {
                aVar.cox.setVisibility(0);
                aVar.cox.setCompoundDrawablesWithIntrinsicBounds(com.baidu.tbadk.core.util.an.getDrawable(i.e.icon_floor_delete_n), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                aVar.cox.setVisibility(8);
            }
            SparseArray sparseArray2 = (SparseArray) aVar.cox.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                aVar.cox.setTag(sparseArray2);
            }
            if (z5) {
                sparseArray2.put(i.f.tag_should_manage_visible, true);
                sparseArray2.put(i.f.tag_manage_user_identity, Integer.valueOf(this.cot));
                sparseArray2.put(i.f.tag_forbid_user_name, oVar.getAuthor().getUserName());
                sparseArray2.put(i.f.tag_forbid_user_post_id, oVar.getId());
            } else {
                sparseArray2.put(i.f.tag_should_manage_visible, false);
            }
            if (z3) {
                if (this.aUg != null) {
                    sparseArray2.put(i.f.tag_display_reply_visible, true);
                    sparseArray2.put(i.f.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (oVar.getAuthor() != null) {
                        sparseArray2.put(i.f.tag_disable_reply_mute_userid, oVar.getAuthor().getUserId());
                        sparseArray2.put(i.f.tag_disable_reply_mute_username, oVar.getAuthor().getUserName());
                    }
                    if (this.aUg.getId() != null) {
                        sparseArray2.put(i.f.tag_disable_reply_thread_id, this.aUg.getId());
                    }
                    sparseArray2.put(i.f.tag_disable_reply_post_id, oVar.getId());
                }
            } else {
                sparseArray2.put(i.f.tag_display_reply_visible, false);
            }
            if (z4) {
                sparseArray2.put(i.f.tag_should_delete_visible, true);
                sparseArray2.put(i.f.tag_manage_user_identity, Integer.valueOf(this.cot));
                sparseArray2.put(i.f.tag_del_post_is_self, Boolean.valueOf(z7));
                sparseArray2.put(i.f.tag_del_post_type, 2);
                sparseArray2.put(i.f.tag_del_post_id, oVar.getId());
                return;
            }
            sparseArray2.put(i.f.tag_should_delete_visible, false);
        }
    }
}
