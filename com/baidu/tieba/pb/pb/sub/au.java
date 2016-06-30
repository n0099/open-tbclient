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
import com.baidu.tbadk.core.data.az;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.u;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class au extends BaseAdapter {
    private az bCH;
    protected Context mContext;
    protected ArrayList<com.baidu.tieba.tbadkCore.data.s> SV = null;
    protected View.OnClickListener dXC = null;
    protected int dXD = 0;
    protected boolean dXE = false;
    protected boolean dNc = false;
    protected boolean aXl = false;
    private boolean mIsFromCDN = true;
    private boolean dXF = false;

    public au(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public int nM(String str) {
        if (this.SV == null) {
            return -1;
        }
        int size = this.SV.size();
        for (int i = 0; i < size; i++) {
            if (this.SV.get(i).getId().equals(str)) {
                return i;
            }
        }
        return -1;
    }

    public void p(az azVar) {
        this.bCH = azVar;
    }

    public void setDatas(ArrayList<com.baidu.tieba.tbadkCore.data.s> arrayList) {
        if (arrayList == null) {
            this.SV = new ArrayList<>();
        } else {
            this.SV = arrayList;
        }
    }

    public void J(View.OnClickListener onClickListener) {
        this.dXC = onClickListener;
    }

    public void J(int i, boolean z) {
        this.dXD = i;
        this.dXE = z;
    }

    public void hh(boolean z) {
        this.dNc = false;
    }

    public void setHasMoreData(boolean z) {
        this.aXl = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.SV == null) {
            return 0;
        }
        return this.SV.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.SV == null || i < 0 || i >= this.SV.size()) {
            return null;
        }
        return this.SV.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = jq();
        }
        a aVar = (a) ((SparseArray) view.getTag()).get(u.g.tag_holder);
        if (aVar != null && getItem(i) != null) {
            a(aVar, (com.baidu.tieba.tbadkCore.data.s) getItem(i), !(!this.aXl && i + 1 >= getCount()), i == 0);
        }
        return view;
    }

    /* loaded from: classes.dex */
    public class a {
        public View axa;
        public TbRichTextView dND;
        public LinearLayout dXG;
        public TextView dXH;
        public int mSkinType = 3;

        public a() {
        }
    }

    public View jq() {
        a aVar = new a();
        View inflate = LayoutInflater.from(this.mContext).inflate(u.h.new_sub_pb_list_item, (ViewGroup) null);
        aVar.axa = inflate;
        aVar.dXG = (LinearLayout) inflate.findViewById(u.g.sub_pb_item_columnlayout);
        if (this.dXF) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar.dXG.getLayoutParams();
            layoutParams.topMargin = com.baidu.adp.lib.util.k.c(this.mContext, u.e.ds8);
            layoutParams.bottomMargin = com.baidu.adp.lib.util.k.c(this.mContext, u.e.ds8);
            aVar.dXG.setLayoutParams(layoutParams);
        }
        aVar.dXH = (TextView) inflate.findViewById(u.g.manage_btn);
        aVar.dND = (TbRichTextView) inflate.findViewById(u.g.new_sub_pb_list_richText);
        aVar.dND.Hr();
        aVar.dND.setLineSpacing(1.2f);
        aVar.dND.setSubPbPost(true);
        aVar.dND.setTextSize(TbConfig.getContentSizeOfLzl(this.mContext));
        aVar.dND.setTextColor(com.baidu.tbadk.core.util.av.getColor(u.d.common_color_10215));
        aVar.dND.setTextCenter(true);
        aVar.dXH.setOnClickListener(this.dXC);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(u.g.tag_holder, aVar);
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
            aVar.mSkinType = TbadkCoreApplication.m9getInst().getSkinType();
            aVar.dND.setPadding(0, 0, 0, 0);
            int skinType = TbadkCoreApplication.m9getInst().getSkinType();
            if (sVar.getAuthor() != null) {
                String userName = sVar.getAuthor().getUserName();
                String userId = sVar.getAuthor().getUserId();
                SparseArray sparseArray = (SparseArray) aVar.axa.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    aVar.axa.setTag(sparseArray);
                }
                sparseArray.put(u.g.tag_photo_username, userName);
                sparseArray.put(u.g.tag_photo_userid, userId);
                sparseArray.put(u.g.tag_clip_board, sVar);
                sparseArray.put(u.g.tag_is_subpb, true);
            }
            aVar.dND.setLinkTextColor(com.baidu.tbadk.core.util.av.getColor(u.d.cp_link_tip_c));
            com.baidu.tbadk.widget.richText.a auL = sVar.auL();
            if (auL != null) {
                ArrayList<com.baidu.tbadk.widget.richText.c> GF = auL.GF();
                if (GF.size() > 0) {
                    if (this.dXF) {
                        com.baidu.tbadk.widget.richText.c cVar2 = GF.get(GF.size() - 1);
                        int type = cVar2.getType();
                        String str = "";
                        if (type == 1) {
                            String y = (GF.size() <= 1 || GF.get(GF.size() + (-2)).getType() == type) ? "  " + ba.y(sVar.getTime()) : ba.y(sVar.getTime());
                            SpannableStringBuilder GL = cVar2.GL();
                            if (auL.aEn) {
                                GL.delete(GL.length() - auL.aEo, GL.length());
                            }
                            str = ba.dz(y);
                            GL.append((CharSequence) str);
                            auL.aEn = true;
                            auL.aEo = str.length();
                            cVar = cVar2;
                        } else if (auL.aEn) {
                            cVar = cVar2;
                        } else {
                            String y2 = ba.y(sVar.getTime());
                            com.baidu.tbadk.widget.richText.c cVar3 = new com.baidu.tbadk.widget.richText.c(1);
                            String dz = ba.dz(y2);
                            cVar3.append(dz);
                            auL.aEn = true;
                            auL.aEo = dz.length();
                            GF.add(cVar3);
                            cVar = cVar3;
                            str = dz;
                        }
                        if (skinType == 1) {
                            textAppearanceSpan = new TextAppearanceSpan(this.mContext, u.k.subtext_entelechy_1);
                        } else {
                            textAppearanceSpan = new TextAppearanceSpan(this.mContext, u.k.subtext_entelechy);
                        }
                        SpannableStringBuilder GL2 = cVar.GL();
                        GL2.setSpan(textAppearanceSpan, GL2.length() - str.length(), GL2.length(), 33);
                    } else {
                        SpannableStringBuilder GL3 = GF.get(GF.size() - 1).GL();
                        if (auL.aEn) {
                            GL3.delete(GL3.length() - auL.aEo, GL3.length());
                        }
                        auL.aEn = false;
                        auL.aEo = 0;
                    }
                }
                aVar.dND.setVoiceViewRes(u.h.voice_play_btn_new);
                aVar.dND.setIsFromCDN(this.mIsFromCDN);
                aVar.dND.setText(sVar.auL());
            }
            String userId2 = sVar.getAuthor().getUserId();
            if (this.dXD != 0) {
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
            if (!this.dXE) {
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
            com.baidu.tbadk.core.util.av.j((View) aVar.dXH, u.d.cp_link_tip_c);
            if (z4) {
                aVar.dXH.setVisibility(0);
                aVar.dXH.setText(this.mContext.getString(u.j.manage));
                aVar.dXH.setContentDescription(this.mContext.getString(u.j.manage));
            } else if (z5) {
                aVar.dXH.setVisibility(0);
                aVar.dXH.setText(this.mContext.getString(u.j.mute));
                aVar.dXH.setContentDescription(this.mContext.getString(u.j.mute));
            } else if (z7) {
                aVar.dXH.setVisibility(0);
                aVar.dXH.setText(this.mContext.getString(u.j.delete));
                aVar.dXH.setContentDescription(this.mContext.getString(u.j.delete));
            } else {
                aVar.dXH.setVisibility(8);
            }
            SparseArray sparseArray2 = (SparseArray) aVar.dXH.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                aVar.dXH.setTag(sparseArray2);
            }
            if (z4) {
                sparseArray2.put(u.g.tag_should_manage_visible, true);
                sparseArray2.put(u.g.tag_manage_user_identity, Integer.valueOf(this.dXD));
                sparseArray2.put(u.g.tag_forbid_user_name, sVar.getAuthor().getUserName());
                sparseArray2.put(u.g.tag_forbid_user_post_id, sVar.getId());
            } else {
                sparseArray2.put(u.g.tag_should_manage_visible, false);
            }
            if (z5) {
                if (this.bCH != null) {
                    sparseArray2.put(u.g.tag_user_mute_visible, true);
                    sparseArray2.put(u.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (sVar.getAuthor() != null) {
                        sparseArray2.put(u.g.tag_user_mute_mute_userid, sVar.getAuthor().getUserId());
                        sparseArray2.put(u.g.tag_user_mute_mute_username, sVar.getAuthor().getUserName());
                    }
                    if (this.bCH.getId() != null) {
                        sparseArray2.put(u.g.tag_user_mute_thread_id, this.bCH.getId());
                    }
                    sparseArray2.put(u.g.tag_user_mute_post_id, sVar.getId());
                }
            } else {
                sparseArray2.put(u.g.tag_user_mute_visible, false);
            }
            if (z7) {
                sparseArray2.put(u.g.tag_should_delete_visible, true);
                sparseArray2.put(u.g.tag_manage_user_identity, Integer.valueOf(this.dXD));
                sparseArray2.put(u.g.tag_del_post_is_self, Boolean.valueOf(z6));
                sparseArray2.put(u.g.tag_del_post_type, 2);
                sparseArray2.put(u.g.tag_del_post_id, sVar.getId());
                return;
            }
            sparseArray2.put(u.g.tag_should_delete_visible, false);
        }
    }

    public void hZ(boolean z) {
        this.dXF = z;
    }
}
