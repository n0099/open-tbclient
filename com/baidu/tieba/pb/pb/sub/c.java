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
import com.baidu.tbadk.core.data.bb;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class c extends BaseAdapter {
    private bb buw;
    protected Context mContext;
    protected ArrayList<PostData> alt = null;
    protected View.OnClickListener fLv = null;
    protected int fLw = 0;
    protected boolean fLx = false;
    protected boolean fLy = false;
    protected boolean cHN = false;
    private boolean mIsFromCDN = true;
    private boolean fLz = false;
    private boolean aMC = false;
    private String mPostId = "";
    private int mSelectedPosition = -1;

    /* loaded from: classes2.dex */
    public static class b {
        public TextView ckN;
        public LinearLayout fLB;
        public View fLC;
        public TbRichTextView fzm;
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

    public void qY(int i) {
        this.mSelectedPosition = i;
    }

    public int rB(String str) {
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

    public void Z(bb bbVar) {
        this.buw = bbVar;
    }

    public void setDatas(ArrayList<PostData> arrayList) {
        if (arrayList == null) {
            this.alt = new ArrayList<>();
        } else {
            this.alt = arrayList;
        }
    }

    public void K(View.OnClickListener onClickListener) {
        this.fLv = onClickListener;
    }

    public void A(int i, boolean z) {
        this.fLw = i;
        this.fLx = z;
    }

    public void setHasMoreData(boolean z) {
        this.cHN = z;
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
            if (postData.getType() == PostData.gNX) {
                view = bfM();
            } else {
                view = np();
            }
        }
        if ((view.getTag() instanceof a) && postData.getType() != PostData.gNX) {
            view = np();
        }
        if ((view.getTag() instanceof SparseArray) && postData.getType() == PostData.gNX) {
            view = bfM();
        }
        if ((view.getTag() instanceof SparseArray) && (bVar = (b) ((SparseArray) view.getTag()).get(d.g.tag_holder)) != null && postData != null) {
            boolean z = !this.cHN && i + 1 >= getCount();
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
        public View bkE;
        public TextView fLA;
        public View mRootView;
        private int mSkinType = 3;

        public a(Context context, View view) {
            this.mRootView = view;
            this.bkE = view.findViewById(d.g.divider_line);
            this.fLA = (TextView) view.findViewById(d.g.center_reply_text);
            this.fLA.setTextSize(0, TbConfig.getContentSizeOfLzl());
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }

        public void onChangeSkinType(int i) {
            if (i != this.mSkinType) {
                am.j(this.bkE, d.C0140d.cp_cont_d);
                am.h(this.fLA, d.C0140d.cp_cont_d);
                am.j(this.fLA, d.C0140d.cp_bg_line_d);
                this.fLA.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.v(i, d.f.icon_floor_arrow_n), (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public View bfM() {
        View inflate = LayoutInflater.from(this.mContext).inflate(d.h.new_sub_pb_list_expand_view, (ViewGroup) null);
        inflate.setTag(new a(this.mContext, inflate));
        return inflate;
    }

    public View np() {
        b bVar = new b();
        View inflate = LayoutInflater.from(this.mContext).inflate(d.h.new_sub_pb_list_item, (ViewGroup) null);
        bVar.rootView = inflate;
        bVar.fLB = (LinearLayout) inflate.findViewById(d.g.sub_pb_item_columnlayout);
        if (this.fLz) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.fLB.getLayoutParams();
            layoutParams.topMargin = l.f(this.mContext, d.e.ds8);
            layoutParams.bottomMargin = l.f(this.mContext, d.e.ds8);
            bVar.fLB.setLayoutParams(layoutParams);
        }
        bVar.ckN = (TextView) inflate.findViewById(d.g.manage_btn);
        bVar.fzm = (TbRichTextView) inflate.findViewById(d.g.new_sub_pb_list_richText);
        bVar.fLC = inflate.findViewById(d.g.divide_bottom_view);
        bVar.fzm.getLayoutStrategy().setSupportNoImage();
        if (!this.fLz) {
            bVar.fzm.getLayoutStrategy().setLineSpacing(l.f(TbadkCoreApplication.getInst().getContext(), d.e.tbds12), 1.0f);
            bVar.fzm.getLayoutStrategy().fX(0);
            bVar.fzm.getLayoutStrategy().fV(l.f(this.mContext, d.e.tbds20));
            bVar.fzm.getLayoutStrategy().fW(l.f(this.mContext, d.e.tbds3));
        }
        bVar.fzm.setSubPbPost(true);
        bVar.fzm.setTextColor(am.getColor(d.C0140d.cp_cont_f));
        bVar.fzm.setTextSize(TbConfig.getContentSizeOfLzl());
        bVar.fzm.setTextCenter(true);
        bVar.ckN.setOnClickListener(this.fLv);
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
                am.j(bVar.rootView, d.C0140d.cp_bg_line_b);
            } else {
                bVar.rootView.setBackgroundResource(0);
            }
            if (postData.bwg()) {
                bVar.fLC.setVisibility(0);
            } else {
                bVar.fLC.setVisibility(8);
            }
            bVar.fzm.setPadding(0, 0, 0, 0);
            if (postData.vk() != null) {
                String name_show = postData.vk().getName_show();
                String userId = postData.vk().getUserId();
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
            bVar.fzm.setLinkTextColor(am.getColor(d.C0140d.cp_link_tip_c));
            bVar.fzm.setTextColor(am.getColor(d.C0140d.cp_cont_f));
            a(postData, this.fLz);
            TbRichText bwh = postData.bwh();
            if (bwh != null) {
                bVar.fzm.setVoiceViewRes(d.h.voice_play_btn_new);
                bVar.fzm.setIsFromCDN(this.mIsFromCDN);
                if (bVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                    bwh.isChanged = true;
                }
                bVar.fzm.setText(bwh);
            }
            String userId2 = postData.vk().getUserId();
            if (this.fLw != 0) {
                boolean z9 = this.fLw != 1002;
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
            if (!this.fLx) {
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
            bVar.ckN.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            bVar.ckN.setText("");
            bVar.ckN.setContentDescription("");
            am.h(bVar.ckN, d.C0140d.cp_link_tip_c);
            if (z5) {
                bVar.ckN.setVisibility(0);
                bVar.ckN.setText(this.mContext.getString(d.j.manage));
                bVar.ckN.setContentDescription(this.mContext.getString(d.j.manage));
            } else if (z6) {
                bVar.ckN.setVisibility(0);
                bVar.ckN.setText(this.mContext.getString(d.j.mute));
                bVar.ckN.setContentDescription(this.mContext.getString(d.j.mute));
            } else if (z8) {
                bVar.ckN.setVisibility(0);
                if (this.fLw == 1002 && !z7) {
                    bVar.ckN.setText(this.mContext.getString(d.j.report_text));
                } else {
                    bVar.ckN.setText(this.mContext.getString(d.j.delete));
                }
            } else {
                bVar.ckN.setVisibility(8);
            }
            SparseArray sparseArray2 = (SparseArray) bVar.ckN.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                bVar.ckN.setTag(sparseArray2);
            }
            sparseArray2.put(d.g.tag_subpb_main_floor_post_id, this.mPostId);
            if (z5) {
                sparseArray2.put(d.g.tag_should_manage_visible, true);
                sparseArray2.put(d.g.tag_manage_user_identity, Integer.valueOf(this.fLw));
                if (postData.vk() != null) {
                    sparseArray2.put(d.g.tag_forbid_user_name, postData.vk().getUserName());
                    sparseArray2.put(d.g.tag_forbid_user_name_show, postData.vk().getName_show());
                    sparseArray2.put(d.g.tag_forbid_user_portrait, postData.vk().getPortrait());
                }
                sparseArray2.put(d.g.tag_forbid_user_post_id, postData.getId());
            } else {
                sparseArray2.put(d.g.tag_should_manage_visible, false);
            }
            if (z6) {
                if (this.buw != null) {
                    sparseArray2.put(d.g.tag_user_mute_visible, true);
                    sparseArray2.put(d.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (postData.vk() != null) {
                        sparseArray2.put(d.g.tag_user_mute_mute_userid, postData.vk().getUserId());
                        sparseArray2.put(d.g.tag_user_mute_mute_username, postData.vk().getUserName());
                        sparseArray2.put(d.g.tag_user_mute_mute_nameshow, postData.vk().getName_show());
                    }
                    if (this.buw.getId() != null) {
                        sparseArray2.put(d.g.tag_user_mute_thread_id, this.buw.getId());
                    }
                    sparseArray2.put(d.g.tag_user_mute_post_id, postData.getId());
                }
            } else {
                sparseArray2.put(d.g.tag_user_mute_visible, false);
            }
            if (z8) {
                sparseArray2.put(d.g.tag_should_delete_visible, true);
                sparseArray2.put(d.g.tag_manage_user_identity, Integer.valueOf(this.fLw));
                sparseArray2.put(d.g.tag_del_post_is_self, Boolean.valueOf(z7));
                sparseArray2.put(d.g.tag_del_post_type, 2);
                sparseArray2.put(d.g.tag_del_post_id, postData.getId());
            } else {
                sparseArray2.put(d.g.tag_should_delete_visible, false);
            }
            if (this.fLz && z2 && this.aMC) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.fLB.getLayoutParams();
                layoutParams.topMargin = l.f(this.mContext, d.e.ds32);
                layoutParams.bottomMargin = l.f(this.mContext, d.e.ds8);
                bVar.fLB.setLayoutParams(layoutParams);
            }
            if (this.fLz && !z2) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.fLB.getLayoutParams();
                layoutParams2.topMargin = l.f(this.mContext, d.e.ds8);
                layoutParams2.bottomMargin = l.f(this.mContext, d.e.ds8);
                bVar.fLB.setLayoutParams(layoutParams2);
            }
            bVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(PostData postData, boolean z) {
        TbRichText bwh;
        SpannableStringBuilder NE;
        TbRichTextData tbRichTextData;
        String str;
        String str2;
        SpannableStringBuilder NE2;
        if (postData != null && (bwh = postData.bwh()) != null) {
            ArrayList<TbRichTextData> Nx = bwh.Nx();
            if (!w.z(Nx)) {
                if (z) {
                    TbRichTextData tbRichTextData2 = Nx.get(Nx.size() - 1);
                    int type = tbRichTextData2 != null ? tbRichTextData2.getType() : -1;
                    if (type == 1) {
                        String str3 = "   " + ap.w(postData.getTime());
                        if (Nx.size() > 1) {
                            if ((Nx.get(Nx.size() + (-2)) != null ? Nx.get(Nx.size() - 2).getType() : -1) != type) {
                                str2 = ap.w(postData.getTime());
                                NE2 = tbRichTextData2.NE();
                                if (bwh.hasAppendTime && NE2 != 0 && bwh.appendLength <= NE2.length()) {
                                    NE2.delete(NE2.length() - bwh.appendLength, NE2.length());
                                }
                                String eI = ap.eI(str2);
                                if (NE2 != null) {
                                    NE2.append((CharSequence) eI);
                                }
                                bwh.hasAppendTime = true;
                                bwh.appendLength = eI.length();
                                tbRichTextData = tbRichTextData2;
                                str = eI;
                            }
                        }
                        str2 = str3;
                        NE2 = tbRichTextData2.NE();
                        if (bwh.hasAppendTime) {
                            NE2.delete(NE2.length() - bwh.appendLength, NE2.length());
                        }
                        String eI2 = ap.eI(str2);
                        if (NE2 != null) {
                        }
                        bwh.hasAppendTime = true;
                        bwh.appendLength = eI2.length();
                        tbRichTextData = tbRichTextData2;
                        str = eI2;
                    } else if (bwh.hasAppendTime) {
                        tbRichTextData = tbRichTextData2;
                        str = "";
                    } else {
                        String w = ap.w(postData.getTime());
                        tbRichTextData = new TbRichTextData(1);
                        str = ap.eI(w);
                        tbRichTextData.append(str);
                        bwh.hasAppendTime = true;
                        bwh.appendLength = str.length();
                        Nx.add(tbRichTextData);
                    }
                    SpannableStringBuilder NE3 = tbRichTextData.NE();
                    if (NE3 != null && str.length() <= NE3.length()) {
                        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(TbConfig.getContentSizeOfLzl());
                        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(am.getColor(d.C0140d.cp_cont_d));
                        NE3.setSpan(absoluteSizeSpan, NE3.length() - str.length(), NE3.length(), 33);
                        NE3.setSpan(foregroundColorSpan, NE3.length() - str.length(), NE3.length(), 33);
                        return;
                    }
                    return;
                }
                TbRichTextData tbRichTextData3 = Nx.get(Nx.size() - 1);
                if (bwh.hasAppendTime && tbRichTextData3 != null && (NE = tbRichTextData3.NE()) != null && bwh.appendLength <= NE.length()) {
                    NE.delete(NE.length() - bwh.appendLength, NE.length());
                }
                bwh.hasAppendTime = false;
                bwh.appendLength = 0;
            }
        }
    }

    public void kK(boolean z) {
        this.fLz = z;
    }

    public void kL(boolean z) {
        this.aMC = z;
    }

    public void rC(String str) {
        this.mPostId = str;
    }
}
