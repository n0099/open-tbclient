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
import com.baidu.tbadk.core.data.bi;
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class av extends BaseAdapter {
    private bi aLV;
    protected Context mContext;
    protected ArrayList<com.baidu.tieba.tbadkCore.data.q> WD = null;
    protected View.OnClickListener eyu = null;
    protected int eyv = 0;
    protected boolean eyw = false;
    protected boolean enq = false;
    protected boolean bev = false;
    private boolean mIsFromCDN = true;
    private boolean eyx = false;
    private String mPostId = "";

    public av(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public int py(String str) {
        if (this.WD == null) {
            return -1;
        }
        int size = this.WD.size();
        for (int i = 0; i < size; i++) {
            if (this.WD.get(i).getId().equals(str)) {
                return i;
            }
        }
        return -1;
    }

    public void b(bi biVar) {
        this.aLV = biVar;
    }

    public void setDatas(ArrayList<com.baidu.tieba.tbadkCore.data.q> arrayList) {
        if (arrayList == null) {
            this.WD = new ArrayList<>();
        } else {
            this.WD = arrayList;
        }
    }

    public void H(View.OnClickListener onClickListener) {
        this.eyu = onClickListener;
    }

    public void N(int i, boolean z) {
        this.eyv = i;
        this.eyw = z;
    }

    public void hR(boolean z) {
        this.enq = false;
    }

    public void setHasMoreData(boolean z) {
        this.bev = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.WD == null) {
            return 0;
        }
        return this.WD.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.WD == null || i < 0 || i >= this.WD.size()) {
            return null;
        }
        return this.WD.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = kk();
        }
        a aVar = (a) ((SparseArray) view.getTag()).get(r.g.tag_holder);
        if (aVar != null && getItem(i) != null) {
            a(aVar, (com.baidu.tieba.tbadkCore.data.q) getItem(i), !(!this.bev && i + 1 >= getCount()), i == 0);
        }
        return view;
    }

    /* loaded from: classes.dex */
    public class a {
        public View aAy;
        public TbRichTextView enS;
        public LinearLayout eyy;
        public TextView eyz;
        public int mSkinType = 3;

        public a() {
        }
    }

    public View kk() {
        a aVar = new a();
        View inflate = LayoutInflater.from(this.mContext).inflate(r.h.new_sub_pb_list_item, (ViewGroup) null);
        aVar.aAy = inflate;
        aVar.eyy = (LinearLayout) inflate.findViewById(r.g.sub_pb_item_columnlayout);
        if (this.eyx) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar.eyy.getLayoutParams();
            layoutParams.topMargin = com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds8);
            layoutParams.bottomMargin = com.baidu.adp.lib.util.k.e(this.mContext, r.e.ds8);
            aVar.eyy.setLayoutParams(layoutParams);
        }
        aVar.eyz = (TextView) inflate.findViewById(r.g.manage_btn);
        aVar.enS = (TbRichTextView) inflate.findViewById(r.g.new_sub_pb_list_richText);
        aVar.enS.IO();
        aVar.enS.setLineSpacing(1.2f);
        aVar.enS.setSubPbPost(true);
        aVar.enS.setTextSize(TbConfig.getContentSizeOfLzl(this.mContext));
        aVar.enS.setTextColor(com.baidu.tbadk.core.util.av.getColor(r.d.common_color_10215));
        aVar.enS.setTextCenter(true);
        aVar.eyz.setOnClickListener(this.eyu);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(r.g.tag_holder, aVar);
        inflate.setTag(sparseArray);
        return inflate;
    }

    public void a(a aVar, com.baidu.tieba.tbadkCore.data.q qVar, boolean z, boolean z2) {
        boolean z3;
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        com.baidu.tbadk.widget.richText.c cVar;
        TextAppearanceSpan textAppearanceSpan;
        if (aVar != null && qVar != null) {
            aVar.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
            aVar.enS.setPadding(0, 0, 0, 0);
            int skinType = TbadkCoreApplication.m9getInst().getSkinType();
            if (qVar.getAuthor() != null) {
                String userName = qVar.getAuthor().getUserName();
                String userId = qVar.getAuthor().getUserId();
                SparseArray sparseArray = (SparseArray) aVar.aAy.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    aVar.aAy.setTag(sparseArray);
                }
                sparseArray.put(r.g.tag_photo_username, userName);
                sparseArray.put(r.g.tag_photo_userid, userId);
                sparseArray.put(r.g.tag_clip_board, qVar);
                sparseArray.put(r.g.tag_is_subpb, true);
            }
            aVar.enS.setLinkTextColor(com.baidu.tbadk.core.util.av.getColor(r.d.cp_link_tip_c));
            com.baidu.tbadk.widget.richText.a aAI = qVar.aAI();
            if (aAI != null) {
                ArrayList<com.baidu.tbadk.widget.richText.c> HZ = aAI.HZ();
                if (HZ.size() > 0) {
                    if (this.eyx) {
                        com.baidu.tbadk.widget.richText.c cVar2 = HZ.get(HZ.size() - 1);
                        int type = cVar2.getType();
                        String str = "";
                        if (type == 1) {
                            String t = (HZ.size() <= 1 || HZ.get(HZ.size() + (-2)).getType() == type) ? "  " + az.t(qVar.getTime()) : az.t(qVar.getTime());
                            SpannableStringBuilder If = cVar2.If();
                            if (aAI.aHN) {
                                If.delete(If.length() - aAI.aHO, If.length());
                            }
                            str = az.dD(t);
                            If.append((CharSequence) str);
                            aAI.aHN = true;
                            aAI.aHO = str.length();
                            cVar = cVar2;
                        } else if (aAI.aHN) {
                            cVar = cVar2;
                        } else {
                            String t2 = az.t(qVar.getTime());
                            com.baidu.tbadk.widget.richText.c cVar3 = new com.baidu.tbadk.widget.richText.c(1);
                            String dD = az.dD(t2);
                            cVar3.append(dD);
                            aAI.aHN = true;
                            aAI.aHO = dD.length();
                            HZ.add(cVar3);
                            cVar = cVar3;
                            str = dD;
                        }
                        if (skinType == 1) {
                            textAppearanceSpan = new TextAppearanceSpan(this.mContext, r.k.subtext_entelechy_1);
                        } else {
                            textAppearanceSpan = new TextAppearanceSpan(this.mContext, r.k.subtext_entelechy);
                        }
                        SpannableStringBuilder If2 = cVar.If();
                        If2.setSpan(textAppearanceSpan, If2.length() - str.length(), If2.length(), 33);
                    } else {
                        SpannableStringBuilder If3 = HZ.get(HZ.size() - 1).If();
                        if (aAI.aHN) {
                            If3.delete(If3.length() - aAI.aHO, If3.length());
                        }
                        aAI.aHN = false;
                        aAI.aHO = 0;
                    }
                }
                aVar.enS.setVoiceViewRes(r.h.voice_play_btn_new);
                aVar.enS.setIsFromCDN(this.mIsFromCDN);
                aVar.enS.setText(qVar.aAI());
            }
            String userId2 = qVar.getAuthor().getUserId();
            if (this.eyv != 0) {
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
            if (!this.eyw) {
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
            com.baidu.tbadk.core.util.av.j((View) aVar.eyz, r.d.cp_link_tip_c);
            if (z4) {
                aVar.eyz.setVisibility(0);
                aVar.eyz.setText(this.mContext.getString(r.j.manage));
                aVar.eyz.setContentDescription(this.mContext.getString(r.j.manage));
            } else if (z5) {
                aVar.eyz.setVisibility(0);
                aVar.eyz.setText(this.mContext.getString(r.j.mute));
                aVar.eyz.setContentDescription(this.mContext.getString(r.j.mute));
            } else if (z7) {
                aVar.eyz.setVisibility(0);
                aVar.eyz.setText(this.mContext.getString(r.j.delete));
                aVar.eyz.setContentDescription(this.mContext.getString(r.j.delete));
            } else {
                aVar.eyz.setVisibility(8);
            }
            SparseArray sparseArray2 = (SparseArray) aVar.eyz.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                aVar.eyz.setTag(sparseArray2);
            }
            sparseArray2.put(r.g.tag_subpb_main_floor_post_id, this.mPostId);
            if (z4) {
                sparseArray2.put(r.g.tag_should_manage_visible, true);
                sparseArray2.put(r.g.tag_manage_user_identity, Integer.valueOf(this.eyv));
                sparseArray2.put(r.g.tag_forbid_user_name, qVar.getAuthor().getUserName());
                sparseArray2.put(r.g.tag_forbid_user_post_id, qVar.getId());
            } else {
                sparseArray2.put(r.g.tag_should_manage_visible, false);
            }
            if (z5) {
                if (this.aLV != null) {
                    sparseArray2.put(r.g.tag_user_mute_visible, true);
                    sparseArray2.put(r.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (qVar.getAuthor() != null) {
                        sparseArray2.put(r.g.tag_user_mute_mute_userid, qVar.getAuthor().getUserId());
                        sparseArray2.put(r.g.tag_user_mute_mute_username, qVar.getAuthor().getUserName());
                    }
                    if (this.aLV.getId() != null) {
                        sparseArray2.put(r.g.tag_user_mute_thread_id, this.aLV.getId());
                    }
                    sparseArray2.put(r.g.tag_user_mute_post_id, qVar.getId());
                }
            } else {
                sparseArray2.put(r.g.tag_user_mute_visible, false);
            }
            if (z7) {
                sparseArray2.put(r.g.tag_should_delete_visible, true);
                sparseArray2.put(r.g.tag_manage_user_identity, Integer.valueOf(this.eyv));
                sparseArray2.put(r.g.tag_del_post_is_self, Boolean.valueOf(z6));
                sparseArray2.put(r.g.tag_del_post_type, 2);
                sparseArray2.put(r.g.tag_del_post_id, qVar.getId());
                return;
            }
            sparseArray2.put(r.g.tag_should_delete_visible, false);
        }
    }

    public void iJ(boolean z) {
        this.eyx = z;
    }

    public void pz(String str) {
        this.mPostId = str;
    }
}
