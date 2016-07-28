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
import com.baidu.tbadk.core.data.be;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.u;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class au extends BaseAdapter {
    private be bDO;
    protected Context mContext;
    protected ArrayList<com.baidu.tieba.tbadkCore.data.s> TD = null;
    protected View.OnClickListener eke = null;
    protected int ekf = 0;
    protected boolean ekg = false;
    protected boolean dZp = false;
    protected boolean aYj = false;
    private boolean mIsFromCDN = true;
    private boolean ekh = false;

    public au(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public int oz(String str) {
        if (this.TD == null) {
            return -1;
        }
        int size = this.TD.size();
        for (int i = 0; i < size; i++) {
            if (this.TD.get(i).getId().equals(str)) {
                return i;
            }
        }
        return -1;
    }

    public void r(be beVar) {
        this.bDO = beVar;
    }

    public void setDatas(ArrayList<com.baidu.tieba.tbadkCore.data.s> arrayList) {
        if (arrayList == null) {
            this.TD = new ArrayList<>();
        } else {
            this.TD = arrayList;
        }
    }

    public void K(View.OnClickListener onClickListener) {
        this.eke = onClickListener;
    }

    public void N(int i, boolean z) {
        this.ekf = i;
        this.ekg = z;
    }

    public void hs(boolean z) {
        this.dZp = false;
    }

    public void setHasMoreData(boolean z) {
        this.aYj = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.TD == null) {
            return 0;
        }
        return this.TD.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.TD == null || i < 0 || i >= this.TD.size()) {
            return null;
        }
        return this.TD.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = jp();
        }
        a aVar = (a) ((SparseArray) view.getTag()).get(u.g.tag_holder);
        if (aVar != null && getItem(i) != null) {
            a(aVar, (com.baidu.tieba.tbadkCore.data.s) getItem(i), !(!this.aYj && i + 1 >= getCount()), i == 0);
        }
        return view;
    }

    /* loaded from: classes.dex */
    public class a {
        public View axO;
        public TbRichTextView dZQ;
        public LinearLayout eki;
        public TextView ekj;
        public int mSkinType = 3;

        public a() {
        }
    }

    public View jp() {
        a aVar = new a();
        View inflate = LayoutInflater.from(this.mContext).inflate(u.h.new_sub_pb_list_item, (ViewGroup) null);
        aVar.axO = inflate;
        aVar.eki = (LinearLayout) inflate.findViewById(u.g.sub_pb_item_columnlayout);
        if (this.ekh) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar.eki.getLayoutParams();
            layoutParams.topMargin = com.baidu.adp.lib.util.k.c(this.mContext, u.e.ds8);
            layoutParams.bottomMargin = com.baidu.adp.lib.util.k.c(this.mContext, u.e.ds8);
            aVar.eki.setLayoutParams(layoutParams);
        }
        aVar.ekj = (TextView) inflate.findViewById(u.g.manage_btn);
        aVar.dZQ = (TbRichTextView) inflate.findViewById(u.g.new_sub_pb_list_richText);
        aVar.dZQ.Hp();
        aVar.dZQ.setLineSpacing(1.2f);
        aVar.dZQ.setSubPbPost(true);
        aVar.dZQ.setTextSize(TbConfig.getContentSizeOfLzl(this.mContext));
        aVar.dZQ.setTextColor(com.baidu.tbadk.core.util.av.getColor(u.d.common_color_10215));
        aVar.dZQ.setTextCenter(true);
        aVar.ekj.setOnClickListener(this.eke);
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
            aVar.mSkinType = TbadkCoreApplication.m10getInst().getSkinType();
            aVar.dZQ.setPadding(0, 0, 0, 0);
            int skinType = TbadkCoreApplication.m10getInst().getSkinType();
            if (sVar.getAuthor() != null) {
                String userName = sVar.getAuthor().getUserName();
                String userId = sVar.getAuthor().getUserId();
                SparseArray sparseArray = (SparseArray) aVar.axO.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    aVar.axO.setTag(sparseArray);
                }
                sparseArray.put(u.g.tag_photo_username, userName);
                sparseArray.put(u.g.tag_photo_userid, userId);
                sparseArray.put(u.g.tag_clip_board, sVar);
                sparseArray.put(u.g.tag_is_subpb, true);
            }
            aVar.dZQ.setLinkTextColor(com.baidu.tbadk.core.util.av.getColor(u.d.cp_link_tip_c));
            com.baidu.tbadk.widget.richText.a avx = sVar.avx();
            if (avx != null) {
                ArrayList<com.baidu.tbadk.widget.richText.c> GD = avx.GD();
                if (GD.size() > 0) {
                    if (this.ekh) {
                        com.baidu.tbadk.widget.richText.c cVar2 = GD.get(GD.size() - 1);
                        int type = cVar2.getType();
                        String str = "";
                        if (type == 1) {
                            String t = (GD.size() <= 1 || GD.get(GD.size() + (-2)).getType() == type) ? "  " + ba.t(sVar.getTime()) : ba.t(sVar.getTime());
                            SpannableStringBuilder GJ = cVar2.GJ();
                            if (avx.aFe) {
                                GJ.delete(GJ.length() - avx.aFf, GJ.length());
                            }
                            str = ba.dy(t);
                            GJ.append((CharSequence) str);
                            avx.aFe = true;
                            avx.aFf = str.length();
                            cVar = cVar2;
                        } else if (avx.aFe) {
                            cVar = cVar2;
                        } else {
                            String t2 = ba.t(sVar.getTime());
                            com.baidu.tbadk.widget.richText.c cVar3 = new com.baidu.tbadk.widget.richText.c(1);
                            String dy = ba.dy(t2);
                            cVar3.append(dy);
                            avx.aFe = true;
                            avx.aFf = dy.length();
                            GD.add(cVar3);
                            cVar = cVar3;
                            str = dy;
                        }
                        if (skinType == 1) {
                            textAppearanceSpan = new TextAppearanceSpan(this.mContext, u.k.subtext_entelechy_1);
                        } else {
                            textAppearanceSpan = new TextAppearanceSpan(this.mContext, u.k.subtext_entelechy);
                        }
                        SpannableStringBuilder GJ2 = cVar.GJ();
                        GJ2.setSpan(textAppearanceSpan, GJ2.length() - str.length(), GJ2.length(), 33);
                    } else {
                        SpannableStringBuilder GJ3 = GD.get(GD.size() - 1).GJ();
                        if (avx.aFe) {
                            GJ3.delete(GJ3.length() - avx.aFf, GJ3.length());
                        }
                        avx.aFe = false;
                        avx.aFf = 0;
                    }
                }
                aVar.dZQ.setVoiceViewRes(u.h.voice_play_btn_new);
                aVar.dZQ.setIsFromCDN(this.mIsFromCDN);
                aVar.dZQ.setText(sVar.avx());
            }
            String userId2 = sVar.getAuthor().getUserId();
            if (this.ekf != 0) {
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
            if (!this.ekg) {
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
            com.baidu.tbadk.core.util.av.j((View) aVar.ekj, u.d.cp_link_tip_c);
            if (z4) {
                aVar.ekj.setVisibility(0);
                aVar.ekj.setText(this.mContext.getString(u.j.manage));
                aVar.ekj.setContentDescription(this.mContext.getString(u.j.manage));
            } else if (z5) {
                aVar.ekj.setVisibility(0);
                aVar.ekj.setText(this.mContext.getString(u.j.mute));
                aVar.ekj.setContentDescription(this.mContext.getString(u.j.mute));
            } else if (z7) {
                aVar.ekj.setVisibility(0);
                aVar.ekj.setText(this.mContext.getString(u.j.delete));
                aVar.ekj.setContentDescription(this.mContext.getString(u.j.delete));
            } else {
                aVar.ekj.setVisibility(8);
            }
            SparseArray sparseArray2 = (SparseArray) aVar.ekj.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                aVar.ekj.setTag(sparseArray2);
            }
            if (z4) {
                sparseArray2.put(u.g.tag_should_manage_visible, true);
                sparseArray2.put(u.g.tag_manage_user_identity, Integer.valueOf(this.ekf));
                sparseArray2.put(u.g.tag_forbid_user_name, sVar.getAuthor().getUserName());
                sparseArray2.put(u.g.tag_forbid_user_post_id, sVar.getId());
            } else {
                sparseArray2.put(u.g.tag_should_manage_visible, false);
            }
            if (z5) {
                if (this.bDO != null) {
                    sparseArray2.put(u.g.tag_user_mute_visible, true);
                    sparseArray2.put(u.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (sVar.getAuthor() != null) {
                        sparseArray2.put(u.g.tag_user_mute_mute_userid, sVar.getAuthor().getUserId());
                        sparseArray2.put(u.g.tag_user_mute_mute_username, sVar.getAuthor().getUserName());
                    }
                    if (this.bDO.getId() != null) {
                        sparseArray2.put(u.g.tag_user_mute_thread_id, this.bDO.getId());
                    }
                    sparseArray2.put(u.g.tag_user_mute_post_id, sVar.getId());
                }
            } else {
                sparseArray2.put(u.g.tag_user_mute_visible, false);
            }
            if (z7) {
                sparseArray2.put(u.g.tag_should_delete_visible, true);
                sparseArray2.put(u.g.tag_manage_user_identity, Integer.valueOf(this.ekf));
                sparseArray2.put(u.g.tag_del_post_is_self, Boolean.valueOf(z6));
                sparseArray2.put(u.g.tag_del_post_type, 2);
                sparseArray2.put(u.g.tag_del_post_id, sVar.getId());
                return;
            }
            sparseArray2.put(u.g.tag_should_delete_visible, false);
        }
    }

    public void il(boolean z) {
        this.ekh = z;
    }
}
