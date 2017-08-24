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
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bl;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.u;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d extends BaseAdapter {
    private bl bgG;
    protected Context mContext;
    protected ArrayList<PostData> acH = null;
    protected View.OnClickListener eXW = null;
    protected int eXX = 0;
    protected boolean eXY = false;
    protected boolean eLu = false;
    protected boolean bPS = false;
    private boolean mIsFromCDN = true;
    private boolean eXZ = false;
    private boolean eXi = false;
    private String mPostId = "";
    private int mSelectedPosition = -1;

    public d(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void pK(int i) {
        this.mSelectedPosition = i;
    }

    public int pO(String str) {
        if (this.acH == null) {
            return -1;
        }
        int size = this.acH.size();
        for (int i = 0; i < size; i++) {
            if (this.acH.get(i).getId().equals(str)) {
                return i;
            }
        }
        return -1;
    }

    public void U(bl blVar) {
        this.bgG = blVar;
    }

    public void setDatas(ArrayList<PostData> arrayList) {
        if (arrayList == null) {
            this.acH = new ArrayList<>();
        } else {
            this.acH = arrayList;
        }
    }

    public void E(View.OnClickListener onClickListener) {
        this.eXW = onClickListener;
    }

    public void C(int i, boolean z) {
        this.eXX = i;
        this.eXY = z;
    }

    public void setHasMoreData(boolean z) {
        this.bPS = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.acH == null) {
            return 0;
        }
        return this.acH.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.acH == null || i < 0 || i >= this.acH.size()) {
            return null;
        }
        return this.acH.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        PostData postData = null;
        if (getItem(i) instanceof PostData) {
            postData = (PostData) getItem(i);
        }
        if (view == null) {
            if (postData.getType() == PostData.gjQ) {
                view = aVU();
            } else {
                view = lj();
            }
        }
        if ((view.getTag() instanceof a) && postData.getType() != PostData.gjQ) {
            view = lj();
        }
        if ((view.getTag() instanceof SparseArray) && postData.getType() == PostData.gjQ) {
            view = aVU();
        }
        if ((view.getTag() instanceof SparseArray) && (bVar = (b) ((SparseArray) view.getTag()).get(d.h.tag_holder)) != null && postData != null) {
            boolean z = !this.bPS && i + 1 >= getCount();
            boolean z2 = i == this.mSelectedPosition;
            a(bVar, postData, !z, i == 0, z2);
            if (z2) {
                this.mSelectedPosition = -1;
            }
        }
        if (view.getTag() instanceof a) {
            ((a) view.getTag()).onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        return view;
    }

    /* loaded from: classes.dex */
    public class b {
        public TextView bwQ;
        public TbRichTextView eHP;
        public LinearLayout eYc;
        public View eYd;
        public int mSkinType = 3;
        public View rootView;

        public b() {
        }
    }

    /* loaded from: classes.dex */
    public class a {
        public View aVD;
        public TextView eYa;
        public View mRootView;
        private int mSkinType = 3;

        public a(Context context, View view) {
            this.mRootView = view;
            this.aVD = view.findViewById(d.h.divider_line);
            this.eYa = (TextView) view.findViewById(d.h.center_reply_text);
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }

        public void onChangeSkinType(int i) {
            if (i != this.mSkinType) {
                ai.k(this.aVD, d.e.cp_cont_d);
                ai.i(this.eYa, d.e.cp_cont_d);
                ai.k(this.eYa, d.e.cp_bg_line_d);
                this.eYa.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ai.v(i, d.g.icon_floor_arrow_n), (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public View aVU() {
        View inflate = LayoutInflater.from(this.mContext).inflate(d.j.new_sub_pb_list_expand_view, (ViewGroup) null);
        inflate.setTag(new a(this.mContext, inflate));
        return inflate;
    }

    public View lj() {
        b bVar = new b();
        View inflate = LayoutInflater.from(this.mContext).inflate(d.j.new_sub_pb_list_item, (ViewGroup) null);
        bVar.rootView = inflate;
        bVar.eYc = (LinearLayout) inflate.findViewById(d.h.sub_pb_item_columnlayout);
        if (this.eXZ) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.eYc.getLayoutParams();
            layoutParams.topMargin = k.g(this.mContext, d.f.ds8);
            layoutParams.bottomMargin = k.g(this.mContext, d.f.ds8);
            bVar.eYc.setLayoutParams(layoutParams);
        }
        bVar.bwQ = (TextView) inflate.findViewById(d.h.manage_btn);
        bVar.eHP = (TbRichTextView) inflate.findViewById(d.h.new_sub_pb_list_richText);
        bVar.eYd = inflate.findViewById(d.h.divide_bottom_view);
        bVar.eHP.Jc();
        bVar.eHP.setSubPbPost(true);
        bVar.eHP.setTextColor(ai.getColor(d.e.cp_cont_f));
        bVar.eHP.setTextCenter(true);
        bVar.bwQ.setOnClickListener(this.eXW);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(d.h.tag_holder, bVar);
        inflate.setTag(sparseArray);
        return inflate;
    }

    public void a(b bVar, PostData postData, boolean z, boolean z2, boolean z3) {
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        if (bVar != null && postData != null) {
            if (z3) {
                ai.k(bVar.rootView, d.e.sub_pb_selected);
            } else {
                bVar.rootView.setBackgroundResource(0);
            }
            if (postData.bta()) {
                bVar.eYd.setVisibility(0);
            } else {
                bVar.eYd.setVisibility(8);
            }
            bVar.eHP.setPadding(0, 0, 0, 0);
            if (postData.getAuthor() != null) {
                String name_show = postData.getAuthor().getName_show();
                String userId = postData.getAuthor().getUserId();
                SparseArray sparseArray = (SparseArray) bVar.rootView.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    bVar.rootView.setTag(sparseArray);
                }
                sparseArray.put(d.h.tag_photo_username, name_show);
                sparseArray.put(d.h.tag_photo_userid, userId);
                sparseArray.put(d.h.tag_clip_board, postData);
                sparseArray.put(d.h.tag_is_subpb, true);
            }
            bVar.eHP.setLinkTextColor(ai.getColor(d.e.cp_link_tip_c));
            bVar.eHP.setTextColor(ai.getColor(d.e.cp_cont_f));
            a(postData, this.eXZ);
            TbRichText aBr = postData.aBr();
            if (aBr != null) {
                bVar.eHP.setVoiceViewRes(d.j.voice_play_btn_new);
                bVar.eHP.setIsFromCDN(this.mIsFromCDN);
                if (bVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                    aBr.isChanged = true;
                }
                bVar.eHP.setText(aBr);
            }
            String userId2 = postData.getAuthor().getUserId();
            if (this.eXX != 0) {
                boolean z9 = userId2 == null || !userId2.equals(TbadkCoreApplication.getCurrentAccount());
                if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                    z4 = true;
                    z5 = false;
                } else {
                    z5 = z9;
                    z4 = true;
                }
            } else {
                z4 = false;
                z5 = false;
            }
            if (!this.eXY) {
                z6 = false;
            } else if (userId2 == null || !userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                z6 = true;
                z4 = true;
            } else {
                z6 = false;
                z4 = true;
            }
            if (userId2 == null || !userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                z7 = false;
                z8 = z4;
            } else {
                z7 = true;
                z8 = true;
            }
            bVar.bwQ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            bVar.bwQ.setText("");
            bVar.bwQ.setContentDescription("");
            ai.i(bVar.bwQ, d.e.cp_link_tip_c);
            if (z5) {
                bVar.bwQ.setVisibility(0);
                bVar.bwQ.setText(this.mContext.getString(d.l.manage));
                bVar.bwQ.setContentDescription(this.mContext.getString(d.l.manage));
            } else if (z6) {
                bVar.bwQ.setVisibility(0);
                bVar.bwQ.setText(this.mContext.getString(d.l.mute));
                bVar.bwQ.setContentDescription(this.mContext.getString(d.l.mute));
            } else if (z8) {
                bVar.bwQ.setVisibility(0);
                bVar.bwQ.setText(this.mContext.getString(d.l.delete));
            } else {
                bVar.bwQ.setVisibility(8);
            }
            SparseArray sparseArray2 = (SparseArray) bVar.bwQ.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                bVar.bwQ.setTag(sparseArray2);
            }
            sparseArray2.put(d.h.tag_subpb_main_floor_post_id, this.mPostId);
            if (z5) {
                sparseArray2.put(d.h.tag_should_manage_visible, true);
                sparseArray2.put(d.h.tag_manage_user_identity, Integer.valueOf(this.eXX));
                sparseArray2.put(d.h.tag_forbid_user_name, postData.getAuthor().getUserName());
                sparseArray2.put(d.h.tag_forbid_user_post_id, postData.getId());
            } else {
                sparseArray2.put(d.h.tag_should_manage_visible, false);
            }
            if (z6) {
                if (this.bgG != null) {
                    sparseArray2.put(d.h.tag_user_mute_visible, true);
                    sparseArray2.put(d.h.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (postData.getAuthor() != null) {
                        sparseArray2.put(d.h.tag_user_mute_mute_userid, postData.getAuthor().getUserId());
                        sparseArray2.put(d.h.tag_user_mute_mute_username, postData.getAuthor().getUserName());
                    }
                    if (this.bgG.getId() != null) {
                        sparseArray2.put(d.h.tag_user_mute_thread_id, this.bgG.getId());
                    }
                    sparseArray2.put(d.h.tag_user_mute_post_id, postData.getId());
                }
            } else {
                sparseArray2.put(d.h.tag_user_mute_visible, false);
            }
            if (z8) {
                sparseArray2.put(d.h.tag_should_delete_visible, true);
                sparseArray2.put(d.h.tag_manage_user_identity, Integer.valueOf(this.eXX));
                sparseArray2.put(d.h.tag_del_post_is_self, Boolean.valueOf(z7));
                sparseArray2.put(d.h.tag_del_post_type, 2);
                sparseArray2.put(d.h.tag_del_post_id, postData.getId());
            } else {
                sparseArray2.put(d.h.tag_should_delete_visible, false);
            }
            if (this.eXZ && z2 && this.eXi) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.eYc.getLayoutParams();
                layoutParams.topMargin = k.g(this.mContext, d.f.ds32);
                layoutParams.bottomMargin = k.g(this.mContext, d.f.ds8);
                bVar.eYc.setLayoutParams(layoutParams);
            }
            if (this.eXZ && !z2) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.eYc.getLayoutParams();
                layoutParams2.topMargin = k.g(this.mContext, d.f.ds8);
                layoutParams2.bottomMargin = k.g(this.mContext, d.f.ds8);
                bVar.eYc.setLayoutParams(layoutParams2);
            }
            bVar.rootView.setPadding(bVar.rootView.getPaddingLeft(), bVar.rootView.getPaddingTop(), bVar.rootView.getPaddingRight(), k.g(this.mContext, d.f.ds10));
            bVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x009e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(PostData postData, boolean z) {
        TbRichText aBr;
        SpannableStringBuilder Iu;
        TbRichTextData tbRichTextData;
        String str;
        TextAppearanceSpan textAppearanceSpan;
        String str2;
        SpannableStringBuilder Iu2;
        if (postData != null && (aBr = postData.aBr()) != null) {
            ArrayList<TbRichTextData> Io = aBr.Io();
            if (!u.v(Io)) {
                if (z) {
                    TbRichTextData tbRichTextData2 = Io.get(Io.size() - 1);
                    int type = tbRichTextData2 != null ? tbRichTextData2.getType() : -1;
                    if (type == 1) {
                        String str3 = "   " + al.r(postData.getTime());
                        if (Io.size() > 1) {
                            if ((Io.get(Io.size() + (-2)) != null ? Io.get(Io.size() - 2).getType() : -1) != type) {
                                str2 = al.r(postData.getTime());
                                Iu2 = tbRichTextData2.Iu();
                                if (aBr.hasAppendTime && Iu2 != 0 && aBr.appendLength <= Iu2.length()) {
                                    Iu2.delete(Iu2.length() - aBr.appendLength, Iu2.length());
                                }
                                String eb = al.eb(str2);
                                if (Iu2 != null) {
                                    Iu2.append((CharSequence) eb);
                                }
                                aBr.hasAppendTime = true;
                                aBr.appendLength = eb.length();
                                tbRichTextData = tbRichTextData2;
                                str = eb;
                            }
                        }
                        str2 = str3;
                        Iu2 = tbRichTextData2.Iu();
                        if (aBr.hasAppendTime) {
                            Iu2.delete(Iu2.length() - aBr.appendLength, Iu2.length());
                        }
                        String eb2 = al.eb(str2);
                        if (Iu2 != null) {
                        }
                        aBr.hasAppendTime = true;
                        aBr.appendLength = eb2.length();
                        tbRichTextData = tbRichTextData2;
                        str = eb2;
                    } else if (aBr.hasAppendTime) {
                        tbRichTextData = tbRichTextData2;
                        str = "";
                    } else {
                        String r = al.r(postData.getTime());
                        tbRichTextData = new TbRichTextData(1);
                        str = al.eb(r);
                        tbRichTextData.append(str);
                        aBr.hasAppendTime = true;
                        aBr.appendLength = str.length();
                        Io.add(tbRichTextData);
                    }
                    if (TbadkCoreApplication.getInst().getSkinType() == 1) {
                        textAppearanceSpan = new TextAppearanceSpan(this.mContext, d.m.subtext_entelechy_1);
                    } else {
                        textAppearanceSpan = new TextAppearanceSpan(this.mContext, d.m.subtext_entelechy);
                    }
                    SpannableStringBuilder Iu3 = tbRichTextData.Iu();
                    if (Iu3 != null && str.length() <= Iu3.length()) {
                        Iu3.setSpan(textAppearanceSpan, Iu3.length() - str.length(), Iu3.length(), 33);
                        return;
                    }
                    return;
                }
                TbRichTextData tbRichTextData3 = Io.get(Io.size() - 1);
                if (aBr.hasAppendTime && tbRichTextData3 != null && (Iu = tbRichTextData3.Iu()) != null && aBr.appendLength <= Iu.length()) {
                    Iu.delete(Iu.length() - aBr.appendLength, Iu.length());
                }
                aBr.hasAppendTime = false;
                aBr.appendLength = 0;
            }
        }
    }

    public void kc(boolean z) {
        this.eXZ = z;
    }

    public void kd(boolean z) {
        this.eXi = z;
    }

    public void pP(String str) {
        this.mPostId = str;
    }
}
