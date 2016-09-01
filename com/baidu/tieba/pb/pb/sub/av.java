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
import com.baidu.tbadk.core.data.bg;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class av extends BaseAdapter {
    private bg bPs;
    protected Context mContext;
    protected ArrayList<com.baidu.tieba.tbadkCore.data.q> Wt = null;
    protected View.OnClickListener ewm = null;
    protected int ewn = 0;
    protected boolean ewo = false;
    protected boolean elt = false;
    protected boolean bec = false;
    private boolean mIsFromCDN = true;
    private boolean ewp = false;
    private String mPostId = "";

    public av(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public int pi(String str) {
        if (this.Wt == null) {
            return -1;
        }
        int size = this.Wt.size();
        for (int i = 0; i < size; i++) {
            if (this.Wt.get(i).getId().equals(str)) {
                return i;
            }
        }
        return -1;
    }

    public void r(bg bgVar) {
        this.bPs = bgVar;
    }

    public void setDatas(ArrayList<com.baidu.tieba.tbadkCore.data.q> arrayList) {
        if (arrayList == null) {
            this.Wt = new ArrayList<>();
        } else {
            this.Wt = arrayList;
        }
    }

    public void I(View.OnClickListener onClickListener) {
        this.ewm = onClickListener;
    }

    public void N(int i, boolean z) {
        this.ewn = i;
        this.ewo = z;
    }

    public void hO(boolean z) {
        this.elt = false;
    }

    public void setHasMoreData(boolean z) {
        this.bec = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.Wt == null) {
            return 0;
        }
        return this.Wt.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.Wt == null || i < 0 || i >= this.Wt.size()) {
            return null;
        }
        return this.Wt.get(i);
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
        a aVar = (a) ((SparseArray) view.getTag()).get(t.g.tag_holder);
        if (aVar != null && getItem(i) != null) {
            a(aVar, (com.baidu.tieba.tbadkCore.data.q) getItem(i), !(!this.bec && i + 1 >= getCount()), i == 0);
        }
        return view;
    }

    /* loaded from: classes.dex */
    public class a {
        public View aAV;
        public TbRichTextView elV;
        public LinearLayout ewq;
        public TextView ewr;
        public int mSkinType = 3;

        public a() {
        }
    }

    public View kk() {
        a aVar = new a();
        View inflate = LayoutInflater.from(this.mContext).inflate(t.h.new_sub_pb_list_item, (ViewGroup) null);
        aVar.aAV = inflate;
        aVar.ewq = (LinearLayout) inflate.findViewById(t.g.sub_pb_item_columnlayout);
        if (this.ewp) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) aVar.ewq.getLayoutParams();
            layoutParams.topMargin = com.baidu.adp.lib.util.k.e(this.mContext, t.e.ds8);
            layoutParams.bottomMargin = com.baidu.adp.lib.util.k.e(this.mContext, t.e.ds8);
            aVar.ewq.setLayoutParams(layoutParams);
        }
        aVar.ewr = (TextView) inflate.findViewById(t.g.manage_btn);
        aVar.elV = (TbRichTextView) inflate.findViewById(t.g.new_sub_pb_list_richText);
        aVar.elV.IO();
        aVar.elV.setLineSpacing(1.2f);
        aVar.elV.setSubPbPost(true);
        aVar.elV.setTextSize(TbConfig.getContentSizeOfLzl(this.mContext));
        aVar.elV.setTextColor(com.baidu.tbadk.core.util.av.getColor(t.d.common_color_10215));
        aVar.elV.setTextCenter(true);
        aVar.ewr.setOnClickListener(this.ewm);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(t.g.tag_holder, aVar);
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
            aVar.elV.setPadding(0, 0, 0, 0);
            int skinType = TbadkCoreApplication.m9getInst().getSkinType();
            if (qVar.getAuthor() != null) {
                String userName = qVar.getAuthor().getUserName();
                String userId = qVar.getAuthor().getUserId();
                SparseArray sparseArray = (SparseArray) aVar.aAV.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    aVar.aAV.setTag(sparseArray);
                }
                sparseArray.put(t.g.tag_photo_username, userName);
                sparseArray.put(t.g.tag_photo_userid, userId);
                sparseArray.put(t.g.tag_clip_board, qVar);
                sparseArray.put(t.g.tag_is_subpb, true);
            }
            aVar.elV.setLinkTextColor(com.baidu.tbadk.core.util.av.getColor(t.d.cp_link_tip_c));
            com.baidu.tbadk.widget.richText.a aAk = qVar.aAk();
            if (aAk != null) {
                ArrayList<com.baidu.tbadk.widget.richText.c> Ia = aAk.Ia();
                if (Ia.size() > 0) {
                    if (this.ewp) {
                        com.baidu.tbadk.widget.richText.c cVar2 = Ia.get(Ia.size() - 1);
                        int type = cVar2.getType();
                        String str = "";
                        if (type == 1) {
                            String t = (Ia.size() <= 1 || Ia.get(Ia.size() + (-2)).getType() == type) ? "  " + ba.t(qVar.getTime()) : ba.t(qVar.getTime());
                            SpannableStringBuilder Ig = cVar2.Ig();
                            if (aAk.aIo) {
                                Ig.delete(Ig.length() - aAk.aIp, Ig.length());
                            }
                            str = ba.dB(t);
                            Ig.append((CharSequence) str);
                            aAk.aIo = true;
                            aAk.aIp = str.length();
                            cVar = cVar2;
                        } else if (aAk.aIo) {
                            cVar = cVar2;
                        } else {
                            String t2 = ba.t(qVar.getTime());
                            com.baidu.tbadk.widget.richText.c cVar3 = new com.baidu.tbadk.widget.richText.c(1);
                            String dB = ba.dB(t2);
                            cVar3.append(dB);
                            aAk.aIo = true;
                            aAk.aIp = dB.length();
                            Ia.add(cVar3);
                            cVar = cVar3;
                            str = dB;
                        }
                        if (skinType == 1) {
                            textAppearanceSpan = new TextAppearanceSpan(this.mContext, t.k.subtext_entelechy_1);
                        } else {
                            textAppearanceSpan = new TextAppearanceSpan(this.mContext, t.k.subtext_entelechy);
                        }
                        SpannableStringBuilder Ig2 = cVar.Ig();
                        Ig2.setSpan(textAppearanceSpan, Ig2.length() - str.length(), Ig2.length(), 33);
                    } else {
                        SpannableStringBuilder Ig3 = Ia.get(Ia.size() - 1).Ig();
                        if (aAk.aIo) {
                            Ig3.delete(Ig3.length() - aAk.aIp, Ig3.length());
                        }
                        aAk.aIo = false;
                        aAk.aIp = 0;
                    }
                }
                aVar.elV.setVoiceViewRes(t.h.voice_play_btn_new);
                aVar.elV.setIsFromCDN(this.mIsFromCDN);
                aVar.elV.setText(qVar.aAk());
            }
            String userId2 = qVar.getAuthor().getUserId();
            if (this.ewn != 0) {
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
            if (!this.ewo) {
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
            com.baidu.tbadk.core.util.av.j((View) aVar.ewr, t.d.cp_link_tip_c);
            if (z4) {
                aVar.ewr.setVisibility(0);
                aVar.ewr.setText(this.mContext.getString(t.j.manage));
                aVar.ewr.setContentDescription(this.mContext.getString(t.j.manage));
            } else if (z5) {
                aVar.ewr.setVisibility(0);
                aVar.ewr.setText(this.mContext.getString(t.j.mute));
                aVar.ewr.setContentDescription(this.mContext.getString(t.j.mute));
            } else if (z7) {
                aVar.ewr.setVisibility(0);
                aVar.ewr.setText(this.mContext.getString(t.j.delete));
                aVar.ewr.setContentDescription(this.mContext.getString(t.j.delete));
            } else {
                aVar.ewr.setVisibility(8);
            }
            SparseArray sparseArray2 = (SparseArray) aVar.ewr.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                aVar.ewr.setTag(sparseArray2);
            }
            sparseArray2.put(t.g.tag_subpb_main_floor_post_id, this.mPostId);
            if (z4) {
                sparseArray2.put(t.g.tag_should_manage_visible, true);
                sparseArray2.put(t.g.tag_manage_user_identity, Integer.valueOf(this.ewn));
                sparseArray2.put(t.g.tag_forbid_user_name, qVar.getAuthor().getUserName());
                sparseArray2.put(t.g.tag_forbid_user_post_id, qVar.getId());
            } else {
                sparseArray2.put(t.g.tag_should_manage_visible, false);
            }
            if (z5) {
                if (this.bPs != null) {
                    sparseArray2.put(t.g.tag_user_mute_visible, true);
                    sparseArray2.put(t.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (qVar.getAuthor() != null) {
                        sparseArray2.put(t.g.tag_user_mute_mute_userid, qVar.getAuthor().getUserId());
                        sparseArray2.put(t.g.tag_user_mute_mute_username, qVar.getAuthor().getUserName());
                    }
                    if (this.bPs.getId() != null) {
                        sparseArray2.put(t.g.tag_user_mute_thread_id, this.bPs.getId());
                    }
                    sparseArray2.put(t.g.tag_user_mute_post_id, qVar.getId());
                }
            } else {
                sparseArray2.put(t.g.tag_user_mute_visible, false);
            }
            if (z7) {
                sparseArray2.put(t.g.tag_should_delete_visible, true);
                sparseArray2.put(t.g.tag_manage_user_identity, Integer.valueOf(this.ewn));
                sparseArray2.put(t.g.tag_del_post_is_self, Boolean.valueOf(z6));
                sparseArray2.put(t.g.tag_del_post_type, 2);
                sparseArray2.put(t.g.tag_del_post_id, qVar.getId());
                return;
            }
            sparseArray2.put(t.g.tag_should_delete_visible, false);
        }
    }

    public void iG(boolean z) {
        this.ewp = z;
    }

    public void pj(String str) {
        this.mPostId = str;
    }
}
