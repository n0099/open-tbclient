package com.baidu.tieba.pb.pb.sub;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class c extends BaseAdapter {
    private bd bso;
    protected Context mContext;
    protected ArrayList<PostData> alt = null;
    protected View.OnClickListener fHg = null;
    protected int fHh = 0;
    protected boolean fHi = false;
    protected boolean fHj = false;
    protected boolean cHm = false;
    private boolean mIsFromCDN = true;
    private boolean fHk = false;
    private boolean aLG = false;
    private String mPostId = "";
    private int mSelectedPosition = -1;

    /* loaded from: classes2.dex */
    public static class b {
        public TextView cgV;
        public LinearLayout fHm;
        public View fHn;
        public TbRichTextView fvm;
        public int mSkinType = 3;
        public View rootView;
    }

    public c(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void qT(int i) {
        this.mSelectedPosition = i;
    }

    public int rI(String str) {
        if (this.alt == null) {
            return -1;
        }
        int size = this.alt.size();
        for (int i = 0; i < size; i++) {
            if (this.alt.get(i).getId().equals(str)) {
                return i;
            }
        }
        return -1;
    }

    public void T(bd bdVar) {
        this.bso = bdVar;
    }

    public void setDatas(ArrayList<PostData> arrayList) {
        if (arrayList == null) {
            this.alt = new ArrayList<>();
        } else {
            this.alt = arrayList;
        }
    }

    public void I(View.OnClickListener onClickListener) {
        this.fHg = onClickListener;
    }

    public void B(int i, boolean z) {
        this.fHh = i;
        this.fHi = z;
    }

    public void setHasMoreData(boolean z) {
        this.cHm = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.alt == null) {
            return 0;
        }
        return this.alt.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.alt == null || i < 0 || i >= this.alt.size()) {
            return null;
        }
        return this.alt.get(i);
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
            if (postData.getType() == PostData.gIY) {
                view = bgM();
            } else {
                view = nn();
            }
        }
        if ((view.getTag() instanceof a) && postData.getType() != PostData.gIY) {
            view = nn();
        }
        if ((view.getTag() instanceof SparseArray) && postData.getType() == PostData.gIY) {
            view = bgM();
        }
        if ((view.getTag() instanceof SparseArray) && (bVar = (b) ((SparseArray) view.getTag()).get(d.g.tag_holder)) != null && postData != null) {
            boolean z = !this.cHm && i + 1 >= getCount();
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

    /* loaded from: classes2.dex */
    public static class a {
        public View biz;
        public TextView fHl;
        public View mRootView;
        private int mSkinType = 3;

        public a(Context context, View view) {
            this.mRootView = view;
            this.biz = view.findViewById(d.g.divider_line);
            this.fHl = (TextView) view.findViewById(d.g.center_reply_text);
            this.fHl.setTextSize(0, TbConfig.getContentSizeOfLzl());
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }

        public void onChangeSkinType(int i) {
            if (i != this.mSkinType) {
                al.j(this.biz, d.C0141d.cp_cont_d);
                al.h(this.fHl, d.C0141d.cp_cont_d);
                al.j(this.fHl, d.C0141d.cp_bg_line_d);
                this.fHl.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.v(i, d.f.icon_floor_arrow_n), (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public View bgM() {
        View inflate = LayoutInflater.from(this.mContext).inflate(d.i.new_sub_pb_list_expand_view, (ViewGroup) null);
        inflate.setTag(new a(this.mContext, inflate));
        return inflate;
    }

    public View nn() {
        b bVar = new b();
        View inflate = LayoutInflater.from(this.mContext).inflate(d.i.new_sub_pb_list_item, (ViewGroup) null);
        bVar.rootView = inflate;
        bVar.fHm = (LinearLayout) inflate.findViewById(d.g.sub_pb_item_columnlayout);
        if (this.fHk) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.fHm.getLayoutParams();
            layoutParams.topMargin = l.e(this.mContext, d.e.ds8);
            layoutParams.bottomMargin = l.e(this.mContext, d.e.ds8);
            bVar.fHm.setLayoutParams(layoutParams);
        }
        bVar.cgV = (TextView) inflate.findViewById(d.g.manage_btn);
        bVar.fvm = (TbRichTextView) inflate.findViewById(d.g.new_sub_pb_list_richText);
        bVar.fHn = inflate.findViewById(d.g.divide_bottom_view);
        bVar.fvm.getLayoutStrategy().setSupportNoImage();
        if (!this.fHk) {
            bVar.fvm.getLayoutStrategy().setLineSpacing(l.e(TbadkCoreApplication.getInst().getContext(), d.e.tbds12), 1.0f);
            bVar.fvm.getLayoutStrategy().fU(0);
            bVar.fvm.getLayoutStrategy().fS(l.e(this.mContext, d.e.tbds20));
            bVar.fvm.getLayoutStrategy().fT(l.e(this.mContext, d.e.tbds3));
        }
        bVar.fvm.setSubPbPost(true);
        bVar.fvm.setTextColor(al.getColor(d.C0141d.cp_cont_f));
        bVar.fvm.setTextSize(TbConfig.getContentSizeOfLzl());
        bVar.fvm.setTextCenter(true);
        bVar.cgV.setOnClickListener(this.fHg);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(d.g.tag_holder, bVar);
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
                al.j(bVar.rootView, d.C0141d.cp_bg_line_b);
            } else {
                bVar.rootView.setBackgroundResource(0);
            }
            if (postData.bxa()) {
                bVar.fHn.setVisibility(0);
            } else {
                bVar.fHn.setVisibility(8);
            }
            bVar.fvm.setPadding(0, 0, 0, 0);
            if (postData.vm() != null) {
                String name_show = postData.vm().getName_show();
                String userId = postData.vm().getUserId();
                SparseArray sparseArray = (SparseArray) bVar.rootView.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    bVar.rootView.setTag(sparseArray);
                }
                sparseArray.put(d.g.tag_photo_username, name_show);
                sparseArray.put(d.g.tag_photo_userid, userId);
                sparseArray.put(d.g.tag_clip_board, postData);
                sparseArray.put(d.g.tag_is_subpb, true);
            }
            bVar.fvm.setLinkTextColor(al.getColor(d.C0141d.cp_link_tip_c));
            bVar.fvm.setTextColor(al.getColor(d.C0141d.cp_cont_f));
            a(postData, this.fHk);
            TbRichText bxb = postData.bxb();
            if (bxb != null) {
                bVar.fvm.setVoiceViewRes(d.i.voice_play_btn_new);
                bVar.fvm.setIsFromCDN(this.mIsFromCDN);
                if (bVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                    bxb.isChanged = true;
                }
                bVar.fvm.setText(bxb);
            }
            String userId2 = postData.vm().getUserId();
            if (this.fHh != 0) {
                boolean z9 = this.fHh != 1002;
                if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z9 = false;
                }
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
            if (!this.fHi) {
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
            bVar.cgV.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            bVar.cgV.setText("");
            bVar.cgV.setContentDescription("");
            al.h(bVar.cgV, d.C0141d.cp_link_tip_c);
            if (z5) {
                bVar.cgV.setVisibility(0);
                bVar.cgV.setText(this.mContext.getString(d.k.manage));
                bVar.cgV.setContentDescription(this.mContext.getString(d.k.manage));
            } else if (z6) {
                bVar.cgV.setVisibility(0);
                bVar.cgV.setText(this.mContext.getString(d.k.mute));
                bVar.cgV.setContentDescription(this.mContext.getString(d.k.mute));
            } else if (z8) {
                bVar.cgV.setVisibility(0);
                if (this.fHh == 1002 && !z7) {
                    bVar.cgV.setText(this.mContext.getString(d.k.report_text));
                } else {
                    bVar.cgV.setText(this.mContext.getString(d.k.delete));
                }
            } else {
                bVar.cgV.setVisibility(8);
            }
            SparseArray sparseArray2 = (SparseArray) bVar.cgV.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                bVar.cgV.setTag(sparseArray2);
            }
            sparseArray2.put(d.g.tag_subpb_main_floor_post_id, this.mPostId);
            if (z5) {
                sparseArray2.put(d.g.tag_should_manage_visible, true);
                sparseArray2.put(d.g.tag_manage_user_identity, Integer.valueOf(this.fHh));
                sparseArray2.put(d.g.tag_forbid_user_name, postData.vm().getUserName());
                sparseArray2.put(d.g.tag_forbid_user_post_id, postData.getId());
            } else {
                sparseArray2.put(d.g.tag_should_manage_visible, false);
            }
            if (z6) {
                if (this.bso != null) {
                    sparseArray2.put(d.g.tag_user_mute_visible, true);
                    sparseArray2.put(d.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (postData.vm() != null) {
                        sparseArray2.put(d.g.tag_user_mute_mute_userid, postData.vm().getUserId());
                        sparseArray2.put(d.g.tag_user_mute_mute_username, postData.vm().getUserName());
                        sparseArray2.put(d.g.tag_user_mute_mute_nameshow, postData.vm().getName_show());
                    }
                    if (this.bso.getId() != null) {
                        sparseArray2.put(d.g.tag_user_mute_thread_id, this.bso.getId());
                    }
                    sparseArray2.put(d.g.tag_user_mute_post_id, postData.getId());
                }
            } else {
                sparseArray2.put(d.g.tag_user_mute_visible, false);
            }
            if (z8) {
                sparseArray2.put(d.g.tag_should_delete_visible, true);
                sparseArray2.put(d.g.tag_manage_user_identity, Integer.valueOf(this.fHh));
                sparseArray2.put(d.g.tag_del_post_is_self, Boolean.valueOf(z7));
                sparseArray2.put(d.g.tag_del_post_type, 2);
                sparseArray2.put(d.g.tag_del_post_id, postData.getId());
            } else {
                sparseArray2.put(d.g.tag_should_delete_visible, false);
            }
            if (this.fHk && z2 && this.aLG) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.fHm.getLayoutParams();
                layoutParams.topMargin = l.e(this.mContext, d.e.ds32);
                layoutParams.bottomMargin = l.e(this.mContext, d.e.ds8);
                bVar.fHm.setLayoutParams(layoutParams);
            }
            if (this.fHk && !z2) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.fHm.getLayoutParams();
                layoutParams2.topMargin = l.e(this.mContext, d.e.ds8);
                layoutParams2.bottomMargin = l.e(this.mContext, d.e.ds8);
                bVar.fHm.setLayoutParams(layoutParams2);
            }
            bVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(PostData postData, boolean z) {
        TbRichText bxb;
        SpannableStringBuilder Nn;
        TbRichTextData tbRichTextData;
        String str;
        String str2;
        SpannableStringBuilder Nn2;
        if (postData != null && (bxb = postData.bxb()) != null) {
            ArrayList<TbRichTextData> Ng = bxb.Ng();
            if (!w.z(Ng)) {
                if (z) {
                    TbRichTextData tbRichTextData2 = Ng.get(Ng.size() - 1);
                    int type = tbRichTextData2 != null ? tbRichTextData2.getType() : -1;
                    if (type == 1) {
                        String str3 = "   " + ao.v(postData.getTime());
                        if (Ng.size() > 1) {
                            if ((Ng.get(Ng.size() + (-2)) != null ? Ng.get(Ng.size() - 2).getType() : -1) != type) {
                                str2 = ao.v(postData.getTime());
                                Nn2 = tbRichTextData2.Nn();
                                if (bxb.hasAppendTime && Nn2 != 0 && bxb.appendLength <= Nn2.length()) {
                                    Nn2.delete(Nn2.length() - bxb.appendLength, Nn2.length());
                                }
                                String eH = ao.eH(str2);
                                if (Nn2 != null) {
                                    Nn2.append((CharSequence) eH);
                                }
                                bxb.hasAppendTime = true;
                                bxb.appendLength = eH.length();
                                tbRichTextData = tbRichTextData2;
                                str = eH;
                            }
                        }
                        str2 = str3;
                        Nn2 = tbRichTextData2.Nn();
                        if (bxb.hasAppendTime) {
                            Nn2.delete(Nn2.length() - bxb.appendLength, Nn2.length());
                        }
                        String eH2 = ao.eH(str2);
                        if (Nn2 != null) {
                        }
                        bxb.hasAppendTime = true;
                        bxb.appendLength = eH2.length();
                        tbRichTextData = tbRichTextData2;
                        str = eH2;
                    } else if (bxb.hasAppendTime) {
                        tbRichTextData = tbRichTextData2;
                        str = "";
                    } else {
                        String v = ao.v(postData.getTime());
                        tbRichTextData = new TbRichTextData(1);
                        str = ao.eH(v);
                        tbRichTextData.append(str);
                        bxb.hasAppendTime = true;
                        bxb.appendLength = str.length();
                        Ng.add(tbRichTextData);
                    }
                    SpannableStringBuilder Nn3 = tbRichTextData.Nn();
                    if (Nn3 != null && str.length() <= Nn3.length()) {
                        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(TbConfig.getContentSizeOfLzl());
                        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(al.getColor(d.C0141d.cp_cont_d));
                        Nn3.setSpan(absoluteSizeSpan, Nn3.length() - str.length(), Nn3.length(), 33);
                        Nn3.setSpan(foregroundColorSpan, Nn3.length() - str.length(), Nn3.length(), 33);
                        return;
                    }
                    return;
                }
                TbRichTextData tbRichTextData3 = Ng.get(Ng.size() - 1);
                if (bxb.hasAppendTime && tbRichTextData3 != null && (Nn = tbRichTextData3.Nn()) != null && bxb.appendLength <= Nn.length()) {
                    Nn.delete(Nn.length() - bxb.appendLength, Nn.length());
                }
                bxb.hasAppendTime = false;
                bxb.appendLength = 0;
            }
        }
    }

    public void kO(boolean z) {
        this.fHk = z;
    }

    public void kP(boolean z) {
        this.aLG = z;
    }

    public void rJ(String str) {
        this.mPostId = str;
    }
}
