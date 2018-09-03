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
import com.baidu.tieba.f;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class c extends BaseAdapter {
    private bb buy;
    protected Context mContext;
    protected ArrayList<PostData> als = null;
    protected View.OnClickListener fLo = null;
    protected int fLp = 0;
    protected boolean fLq = false;
    protected boolean fLr = false;
    protected boolean cHK = false;
    private boolean mIsFromCDN = true;
    private boolean fLs = false;
    private boolean aMz = false;
    private String mPostId = "";
    private int mSelectedPosition = -1;

    /* loaded from: classes2.dex */
    public static class b {
        public TextView ckK;
        public LinearLayout fLu;
        public View fLv;
        public TbRichTextView fzf;
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

    public int rE(String str) {
        if (this.als == null) {
            return -1;
        }
        int size = this.als.size();
        for (int i = 0; i < size; i++) {
            if (this.als.get(i).getId().equals(str)) {
                return i;
            }
        }
        return -1;
    }

    public void Z(bb bbVar) {
        this.buy = bbVar;
    }

    public void setDatas(ArrayList<PostData> arrayList) {
        if (arrayList == null) {
            this.als = new ArrayList<>();
        } else {
            this.als = arrayList;
        }
    }

    public void K(View.OnClickListener onClickListener) {
        this.fLo = onClickListener;
    }

    public void A(int i, boolean z) {
        this.fLp = i;
        this.fLq = z;
    }

    public void setHasMoreData(boolean z) {
        this.cHK = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.als == null) {
            return 0;
        }
        return this.als.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.als == null || i < 0 || i >= this.als.size()) {
            return null;
        }
        return this.als.get(i);
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
            if (postData.getType() == PostData.gNZ) {
                view = bfH();
            } else {
                view = np();
            }
        }
        if ((view.getTag() instanceof a) && postData.getType() != PostData.gNZ) {
            view = np();
        }
        if ((view.getTag() instanceof SparseArray) && postData.getType() == PostData.gNZ) {
            view = bfH();
        }
        if ((view.getTag() instanceof SparseArray) && (bVar = (b) ((SparseArray) view.getTag()).get(f.g.tag_holder)) != null && postData != null) {
            boolean z = !this.cHK && i + 1 >= getCount();
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
        public View bkJ;
        public TextView fLt;
        public View mRootView;
        private int mSkinType = 3;

        public a(Context context, View view) {
            this.mRootView = view;
            this.bkJ = view.findViewById(f.g.divider_line);
            this.fLt = (TextView) view.findViewById(f.g.center_reply_text);
            this.fLt.setTextSize(0, TbConfig.getContentSizeOfLzl());
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }

        public void onChangeSkinType(int i) {
            if (i != this.mSkinType) {
                am.j(this.bkJ, f.d.cp_cont_d);
                am.h(this.fLt, f.d.cp_cont_d);
                am.j(this.fLt, f.d.cp_bg_line_d);
                this.fLt.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.v(i, f.C0146f.icon_floor_arrow_n), (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public View bfH() {
        View inflate = LayoutInflater.from(this.mContext).inflate(f.h.new_sub_pb_list_expand_view, (ViewGroup) null);
        inflate.setTag(new a(this.mContext, inflate));
        return inflate;
    }

    public View np() {
        b bVar = new b();
        View inflate = LayoutInflater.from(this.mContext).inflate(f.h.new_sub_pb_list_item, (ViewGroup) null);
        bVar.rootView = inflate;
        bVar.fLu = (LinearLayout) inflate.findViewById(f.g.sub_pb_item_columnlayout);
        if (this.fLs) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.fLu.getLayoutParams();
            layoutParams.topMargin = l.f(this.mContext, f.e.ds8);
            layoutParams.bottomMargin = l.f(this.mContext, f.e.ds8);
            bVar.fLu.setLayoutParams(layoutParams);
        }
        bVar.ckK = (TextView) inflate.findViewById(f.g.manage_btn);
        bVar.fzf = (TbRichTextView) inflate.findViewById(f.g.new_sub_pb_list_richText);
        bVar.fLv = inflate.findViewById(f.g.divide_bottom_view);
        bVar.fzf.getLayoutStrategy().setSupportNoImage();
        if (!this.fLs) {
            bVar.fzf.getLayoutStrategy().setLineSpacing(l.f(TbadkCoreApplication.getInst().getContext(), f.e.tbds12), 1.0f);
            bVar.fzf.getLayoutStrategy().fW(0);
            bVar.fzf.getLayoutStrategy().fU(l.f(this.mContext, f.e.tbds20));
            bVar.fzf.getLayoutStrategy().fV(l.f(this.mContext, f.e.tbds3));
        }
        bVar.fzf.setSubPbPost(true);
        bVar.fzf.setTextColor(am.getColor(f.d.cp_cont_f));
        bVar.fzf.setTextSize(TbConfig.getContentSizeOfLzl());
        bVar.fzf.setTextCenter(true);
        bVar.ckK.setOnClickListener(this.fLo);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(f.g.tag_holder, bVar);
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
                am.j(bVar.rootView, f.d.cp_bg_line_b);
            } else {
                bVar.rootView.setBackgroundResource(0);
            }
            if (postData.bwh()) {
                bVar.fLv.setVisibility(0);
            } else {
                bVar.fLv.setVisibility(8);
            }
            bVar.fzf.setPadding(0, 0, 0, 0);
            if (postData.vj() != null) {
                String name_show = postData.vj().getName_show();
                String userId = postData.vj().getUserId();
                SparseArray sparseArray = (SparseArray) bVar.rootView.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    bVar.rootView.setTag(sparseArray);
                }
                sparseArray.put(f.g.tag_photo_username, name_show);
                sparseArray.put(f.g.tag_photo_userid, userId);
                sparseArray.put(f.g.tag_clip_board, postData);
                sparseArray.put(f.g.tag_is_subpb, true);
            }
            bVar.fzf.setLinkTextColor(am.getColor(f.d.cp_link_tip_c));
            bVar.fzf.setTextColor(am.getColor(f.d.cp_cont_f));
            a(postData, this.fLs);
            TbRichText bwi = postData.bwi();
            if (bwi != null) {
                bVar.fzf.setVoiceViewRes(f.h.voice_play_btn_new);
                bVar.fzf.setIsFromCDN(this.mIsFromCDN);
                if (bVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                    bwi.isChanged = true;
                }
                bVar.fzf.setText(bwi);
            }
            String userId2 = postData.vj().getUserId();
            if (this.fLp != 0) {
                boolean z9 = this.fLp != 1002;
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
            if (!this.fLq) {
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
            bVar.ckK.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            bVar.ckK.setText("");
            bVar.ckK.setContentDescription("");
            am.h(bVar.ckK, f.d.cp_link_tip_c);
            if (z5) {
                bVar.ckK.setVisibility(0);
                bVar.ckK.setText(this.mContext.getString(f.j.manage));
                bVar.ckK.setContentDescription(this.mContext.getString(f.j.manage));
            } else if (z6) {
                bVar.ckK.setVisibility(0);
                bVar.ckK.setText(this.mContext.getString(f.j.mute));
                bVar.ckK.setContentDescription(this.mContext.getString(f.j.mute));
            } else if (z8) {
                bVar.ckK.setVisibility(0);
                if (this.fLp == 1002 && !z7) {
                    bVar.ckK.setText(this.mContext.getString(f.j.report_text));
                } else {
                    bVar.ckK.setText(this.mContext.getString(f.j.delete));
                }
            } else {
                bVar.ckK.setVisibility(8);
            }
            SparseArray sparseArray2 = (SparseArray) bVar.ckK.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                bVar.ckK.setTag(sparseArray2);
            }
            sparseArray2.put(f.g.tag_subpb_main_floor_post_id, this.mPostId);
            if (z5) {
                sparseArray2.put(f.g.tag_should_manage_visible, true);
                sparseArray2.put(f.g.tag_manage_user_identity, Integer.valueOf(this.fLp));
                if (postData.vj() != null) {
                    sparseArray2.put(f.g.tag_forbid_user_name, postData.vj().getUserName());
                    sparseArray2.put(f.g.tag_forbid_user_name_show, postData.vj().getName_show());
                    sparseArray2.put(f.g.tag_forbid_user_portrait, postData.vj().getPortrait());
                }
                sparseArray2.put(f.g.tag_forbid_user_post_id, postData.getId());
            } else {
                sparseArray2.put(f.g.tag_should_manage_visible, false);
            }
            if (z6) {
                if (this.buy != null) {
                    sparseArray2.put(f.g.tag_user_mute_visible, true);
                    sparseArray2.put(f.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (postData.vj() != null) {
                        sparseArray2.put(f.g.tag_user_mute_mute_userid, postData.vj().getUserId());
                        sparseArray2.put(f.g.tag_user_mute_mute_username, postData.vj().getUserName());
                        sparseArray2.put(f.g.tag_user_mute_mute_nameshow, postData.vj().getName_show());
                    }
                    if (this.buy.getId() != null) {
                        sparseArray2.put(f.g.tag_user_mute_thread_id, this.buy.getId());
                    }
                    sparseArray2.put(f.g.tag_user_mute_post_id, postData.getId());
                }
            } else {
                sparseArray2.put(f.g.tag_user_mute_visible, false);
            }
            if (z8) {
                sparseArray2.put(f.g.tag_should_delete_visible, true);
                sparseArray2.put(f.g.tag_manage_user_identity, Integer.valueOf(this.fLp));
                sparseArray2.put(f.g.tag_del_post_is_self, Boolean.valueOf(z7));
                sparseArray2.put(f.g.tag_del_post_type, 2);
                sparseArray2.put(f.g.tag_del_post_id, postData.getId());
            } else {
                sparseArray2.put(f.g.tag_should_delete_visible, false);
            }
            if (this.fLs && z2 && this.aMz) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.fLu.getLayoutParams();
                layoutParams.topMargin = l.f(this.mContext, f.e.ds32);
                layoutParams.bottomMargin = l.f(this.mContext, f.e.ds8);
                bVar.fLu.setLayoutParams(layoutParams);
            }
            if (this.fLs && !z2) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.fLu.getLayoutParams();
                layoutParams2.topMargin = l.f(this.mContext, f.e.ds8);
                layoutParams2.bottomMargin = l.f(this.mContext, f.e.ds8);
                bVar.fLu.setLayoutParams(layoutParams2);
            }
            bVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(PostData postData, boolean z) {
        TbRichText bwi;
        SpannableStringBuilder ND;
        TbRichTextData tbRichTextData;
        String str;
        String str2;
        SpannableStringBuilder ND2;
        if (postData != null && (bwi = postData.bwi()) != null) {
            ArrayList<TbRichTextData> Nw = bwi.Nw();
            if (!w.z(Nw)) {
                if (z) {
                    TbRichTextData tbRichTextData2 = Nw.get(Nw.size() - 1);
                    int type = tbRichTextData2 != null ? tbRichTextData2.getType() : -1;
                    if (type == 1) {
                        String str3 = "   " + ap.w(postData.getTime());
                        if (Nw.size() > 1) {
                            if ((Nw.get(Nw.size() + (-2)) != null ? Nw.get(Nw.size() - 2).getType() : -1) != type) {
                                str2 = ap.w(postData.getTime());
                                ND2 = tbRichTextData2.ND();
                                if (bwi.hasAppendTime && ND2 != 0 && bwi.appendLength <= ND2.length()) {
                                    ND2.delete(ND2.length() - bwi.appendLength, ND2.length());
                                }
                                String eI = ap.eI(str2);
                                if (ND2 != null) {
                                    ND2.append((CharSequence) eI);
                                }
                                bwi.hasAppendTime = true;
                                bwi.appendLength = eI.length();
                                tbRichTextData = tbRichTextData2;
                                str = eI;
                            }
                        }
                        str2 = str3;
                        ND2 = tbRichTextData2.ND();
                        if (bwi.hasAppendTime) {
                            ND2.delete(ND2.length() - bwi.appendLength, ND2.length());
                        }
                        String eI2 = ap.eI(str2);
                        if (ND2 != null) {
                        }
                        bwi.hasAppendTime = true;
                        bwi.appendLength = eI2.length();
                        tbRichTextData = tbRichTextData2;
                        str = eI2;
                    } else if (bwi.hasAppendTime) {
                        tbRichTextData = tbRichTextData2;
                        str = "";
                    } else {
                        String w = ap.w(postData.getTime());
                        tbRichTextData = new TbRichTextData(1);
                        str = ap.eI(w);
                        tbRichTextData.append(str);
                        bwi.hasAppendTime = true;
                        bwi.appendLength = str.length();
                        Nw.add(tbRichTextData);
                    }
                    SpannableStringBuilder ND3 = tbRichTextData.ND();
                    if (ND3 != null && str.length() <= ND3.length()) {
                        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(TbConfig.getContentSizeOfLzl());
                        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(am.getColor(f.d.cp_cont_d));
                        ND3.setSpan(absoluteSizeSpan, ND3.length() - str.length(), ND3.length(), 33);
                        ND3.setSpan(foregroundColorSpan, ND3.length() - str.length(), ND3.length(), 33);
                        return;
                    }
                    return;
                }
                TbRichTextData tbRichTextData3 = Nw.get(Nw.size() - 1);
                if (bwi.hasAppendTime && tbRichTextData3 != null && (ND = tbRichTextData3.ND()) != null && bwi.appendLength <= ND.length()) {
                    ND.delete(ND.length() - bwi.appendLength, ND.length());
                }
                bwi.hasAppendTime = false;
                bwi.appendLength = 0;
            }
        }
    }

    public void kK(boolean z) {
        this.fLs = z;
    }

    public void kL(boolean z) {
        this.aMz = z;
    }

    public void rF(String str) {
        this.mPostId = str;
    }
}
