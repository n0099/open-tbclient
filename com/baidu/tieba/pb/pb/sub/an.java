package com.baidu.tieba.pb.pb.sub;

import android.content.Context;
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
import com.baidu.tbadk.core.data.ax;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class an extends BaseAdapter {
    private ax bgt;
    protected Context mContext;
    protected ArrayList<com.baidu.tieba.tbadkCore.data.s> SE = null;
    protected View.OnClickListener dqR = null;
    protected int dqS = 0;
    protected boolean dqT = false;
    protected boolean dfJ = false;
    protected boolean aTQ = false;
    private boolean mIsFromCDN = true;
    private boolean dqU = false;

    public an(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public int ml(String str) {
        if (this.SE == null) {
            return -1;
        }
        int size = this.SE.size();
        for (int i = 0; i < size; i++) {
            if (this.SE.get(i).getId().equals(str)) {
                return i;
            }
        }
        return -1;
    }

    public void l(ax axVar) {
        this.bgt = axVar;
    }

    public void setDatas(ArrayList<com.baidu.tieba.tbadkCore.data.s> arrayList) {
        if (arrayList == null) {
            this.SE = new ArrayList<>();
        } else {
            this.SE = arrayList;
        }
    }

    public void J(View.OnClickListener onClickListener) {
        this.dqR = onClickListener;
    }

    public void v(int i, boolean z) {
        this.dqS = i;
        this.dqT = z;
    }

    public void gr(boolean z) {
        this.dfJ = false;
    }

    public void setHasMoreData(boolean z) {
        this.aTQ = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.SE == null) {
            return 0;
        }
        return this.SE.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.SE == null || i < 0 || i >= this.SE.size()) {
            return null;
        }
        return this.SE.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = jn();
        }
        a aVar = (a) ((SparseArray) view.getTag()).get(t.g.tag_holder);
        if (aVar != null && getItem(i) != null) {
            a(aVar, (com.baidu.tieba.tbadkCore.data.s) getItem(i), !(!this.aTQ && i + 1 >= getCount()), i == 0);
        }
        return view;
    }

    /* loaded from: classes.dex */
    public class a {
        public View awk;
        public TbRichTextView dfT;
        public LinearLayout dqV;
        public TextView dqW;
        public int mSkinType = 3;

        public a() {
        }
    }

    public View jn() {
        a aVar = new a();
        View inflate = LayoutInflater.from(this.mContext).inflate(t.h.new_sub_pb_list_item, (ViewGroup) null);
        aVar.awk = inflate;
        aVar.dqV = (LinearLayout) inflate.findViewById(t.g.sub_pb_item_columnlayout);
        if (this.dqU) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar.dqV.getLayoutParams();
            layoutParams.topMargin = com.baidu.adp.lib.util.k.c(this.mContext, t.e.ds8);
            layoutParams.bottomMargin = com.baidu.adp.lib.util.k.c(this.mContext, t.e.ds8);
            aVar.dqV.setLayoutParams(layoutParams);
        }
        aVar.dqW = (TextView) inflate.findViewById(t.g.manage_btn);
        aVar.dfT = (TbRichTextView) inflate.findViewById(t.g.new_sub_pb_list_richText);
        aVar.dfT.Hq();
        aVar.dfT.setLineSpacing(1.2f);
        aVar.dfT.setSubPbPost(true);
        aVar.dfT.setTextSize(TbConfig.getContentSizeOfLzl(this.mContext));
        aVar.dfT.setTextColor(at.getColor(t.d.gray_day_3));
        aVar.dqW.setOnClickListener(this.dqR);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(t.g.tag_holder, aVar);
        inflate.setTag(sparseArray);
        return inflate;
    }

    public void a(a aVar, com.baidu.tieba.tbadkCore.data.s sVar, boolean z, boolean z2) {
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        com.baidu.tbadk.widget.richText.c cVar;
        TextAppearanceSpan textAppearanceSpan;
        if (aVar != null && sVar != null) {
            aVar.mSkinType = TbadkCoreApplication.m11getInst().getSkinType();
            aVar.dfT.setPadding(0, 0, 0, 0);
            int skinType = TbadkCoreApplication.m11getInst().getSkinType();
            if (sVar.getAuthor() != null) {
                String userName = sVar.getAuthor().getUserName();
                String userId = sVar.getAuthor().getUserId();
                SparseArray sparseArray = (SparseArray) aVar.awk.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    aVar.awk.setTag(sparseArray);
                }
                sparseArray.put(t.g.tag_photo_username, userName);
                sparseArray.put(t.g.tag_photo_userid, userId);
                sparseArray.put(t.g.tag_clip_board, sVar);
                sparseArray.put(t.g.tag_is_subpb, true);
            }
            aVar.dfT.setLinkTextColor(at.getColor(t.d.cp_link_tip_c));
            com.baidu.tbadk.widget.richText.a amz = sVar.amz();
            if (amz != null) {
                ArrayList<com.baidu.tbadk.widget.richText.c> GE = amz.GE();
                if (GE.size() > 0) {
                    if (this.dqU) {
                        com.baidu.tbadk.widget.richText.c cVar2 = GE.get(GE.size() - 1);
                        int type = cVar2.getType();
                        String str = "";
                        if (type == 1) {
                            String x = (GE.size() <= 1 || GE.get(GE.size() + (-2)).getType() == type) ? "  " + ay.x(sVar.getTime()) : ay.x(sVar.getTime());
                            SpannableStringBuilder GK = cVar2.GK();
                            if (amz.aDN) {
                                GK.delete(GK.length() - amz.aDO, GK.length());
                            }
                            str = ay.dw(x);
                            GK.append((CharSequence) str);
                            amz.aDN = true;
                            amz.aDO = str.length();
                            cVar = cVar2;
                        } else if (amz.aDN) {
                            cVar = cVar2;
                        } else {
                            String x2 = ay.x(sVar.getTime());
                            com.baidu.tbadk.widget.richText.c cVar3 = new com.baidu.tbadk.widget.richText.c(1);
                            String dw = ay.dw(x2);
                            cVar3.append(dw);
                            amz.aDN = true;
                            amz.aDO = dw.length();
                            GE.add(cVar3);
                            cVar = cVar3;
                            str = dw;
                        }
                        if (skinType == 1) {
                            textAppearanceSpan = new TextAppearanceSpan(this.mContext, t.k.subtext_entelechy_1);
                        } else {
                            textAppearanceSpan = new TextAppearanceSpan(this.mContext, t.k.subtext_entelechy);
                        }
                        SpannableStringBuilder GK2 = cVar.GK();
                        GK2.setSpan(textAppearanceSpan, GK2.length() - str.length(), GK2.length(), 33);
                    } else {
                        SpannableStringBuilder GK3 = GE.get(GE.size() - 1).GK();
                        if (amz.aDN) {
                            GK3.delete(GK3.length() - amz.aDO, GK3.length());
                        }
                        amz.aDN = false;
                        amz.aDO = 0;
                    }
                }
                aVar.dfT.setVoiceViewRes(t.h.voice_play_btn);
                aVar.dfT.setIsFromCDN(this.mIsFromCDN);
                aVar.dfT.setText(sVar.amz());
            }
            String userId2 = sVar.getAuthor().getUserId();
            if (this.dqS != 0) {
                boolean z8 = userId2 == null || !userId2.equals(TbadkCoreApplication.getCurrentAccount());
                if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                    z3 = true;
                    z4 = false;
                } else {
                    z4 = z8;
                    z3 = true;
                }
            } else {
                z3 = false;
                z4 = false;
            }
            if (!this.dqT) {
                z5 = false;
            } else if (userId2 == null || !userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                z5 = true;
                z3 = true;
            } else {
                z5 = false;
                z3 = true;
            }
            if (userId2 == null || !userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                z6 = false;
                z7 = z3;
            } else {
                z6 = true;
                z7 = true;
            }
            at.j((View) aVar.dqW, t.d.cp_link_tip_c);
            if (z4) {
                aVar.dqW.setVisibility(0);
                aVar.dqW.setText(this.mContext.getString(t.j.manage));
                aVar.dqW.setContentDescription(this.mContext.getString(t.j.manage));
            } else if (z5) {
                aVar.dqW.setVisibility(0);
                aVar.dqW.setText(this.mContext.getString(t.j.mute));
                aVar.dqW.setContentDescription(this.mContext.getString(t.j.mute));
            } else if (z7) {
                aVar.dqW.setVisibility(0);
                aVar.dqW.setText(this.mContext.getString(t.j.delete));
                aVar.dqW.setContentDescription(this.mContext.getString(t.j.delete));
            } else {
                aVar.dqW.setVisibility(8);
            }
            SparseArray sparseArray2 = (SparseArray) aVar.dqW.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                aVar.dqW.setTag(sparseArray2);
            }
            if (z4) {
                sparseArray2.put(t.g.tag_should_manage_visible, true);
                sparseArray2.put(t.g.tag_manage_user_identity, Integer.valueOf(this.dqS));
                sparseArray2.put(t.g.tag_forbid_user_name, sVar.getAuthor().getUserName());
                sparseArray2.put(t.g.tag_forbid_user_post_id, sVar.getId());
            } else {
                sparseArray2.put(t.g.tag_should_manage_visible, false);
            }
            if (z5) {
                if (this.bgt != null) {
                    sparseArray2.put(t.g.tag_user_mute_visible, true);
                    sparseArray2.put(t.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (sVar.getAuthor() != null) {
                        sparseArray2.put(t.g.tag_user_mute_mute_userid, sVar.getAuthor().getUserId());
                        sparseArray2.put(t.g.tag_user_mute_mute_username, sVar.getAuthor().getUserName());
                    }
                    if (this.bgt.getId() != null) {
                        sparseArray2.put(t.g.tag_user_mute_thread_id, this.bgt.getId());
                    }
                    sparseArray2.put(t.g.tag_user_mute_post_id, sVar.getId());
                }
            } else {
                sparseArray2.put(t.g.tag_user_mute_visible, false);
            }
            if (z7) {
                sparseArray2.put(t.g.tag_should_delete_visible, true);
                sparseArray2.put(t.g.tag_manage_user_identity, Integer.valueOf(this.dqS));
                sparseArray2.put(t.g.tag_del_post_is_self, Boolean.valueOf(z6));
                sparseArray2.put(t.g.tag_del_post_type, 2);
                sparseArray2.put(t.g.tag_del_post_id, sVar.getId());
                return;
            }
            sparseArray2.put(t.g.tag_should_delete_visible, false);
        }
    }

    public void hf(boolean z) {
        this.dqU = z;
    }
}
