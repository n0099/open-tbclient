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
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.e;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class c extends BaseAdapter {
    private bb bOk;
    protected Context mContext;
    protected ArrayList<PostData> mData = null;
    protected View.OnClickListener gmD = null;
    protected int gmE = 0;
    protected boolean gmF = false;
    protected boolean gmG = false;
    protected boolean dhm = false;
    private boolean mIsFromCDN = true;
    private boolean aFB = false;
    private boolean aZs = false;
    private String mPostId = "";
    private int mSelectedPosition = -1;
    private View.OnLongClickListener aTZ = null;
    private View.OnClickListener mCommonClickListener = null;

    /* loaded from: classes6.dex */
    public static class b {
        public TextView cFR;
        public TbRichTextView gax;
        public LinearLayout gmI;
        public View gmJ;
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

    public void aa(bb bbVar) {
        this.bOk = bbVar;
    }

    public void M(View.OnClickListener onClickListener) {
        this.gmD = onClickListener;
    }

    public void B(int i, boolean z) {
        this.gmE = i;
        this.gmF = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.mData == null) {
            return 0;
        }
        return this.mData.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.mData == null || i < 0 || i >= this.mData.size()) {
            return null;
        }
        return this.mData.get(i);
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
            if (postData.getType() == PostData.hpG) {
                view = bof();
            } else {
                view = oH();
            }
        }
        if ((view.getTag() instanceof a) && postData.getType() != PostData.hpG) {
            view = oH();
        }
        if ((view.getTag() instanceof SparseArray) && postData.getType() == PostData.hpG) {
            view = bof();
        }
        if ((view.getTag() instanceof SparseArray) && (bVar = (b) ((SparseArray) view.getTag()).get(e.g.tag_holder)) != null && postData != null) {
            boolean z = !this.dhm && i + 1 >= getCount();
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

    /* loaded from: classes6.dex */
    public static class a {
        public View bzG;
        public TextView gmH;
        public View mRootView;
        private int mSkinType = 3;

        public a(Context context, View view) {
            this.mRootView = view;
            this.bzG = view.findViewById(e.g.divider_line);
            this.gmH = (TextView) view.findViewById(e.g.center_reply_text);
            this.gmH.setTextSize(0, TbConfig.getContentSizeOfLzl());
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }

        public void onChangeSkinType(int i) {
            if (i != this.mSkinType) {
                al.j(this.bzG, e.d.cp_cont_d);
                al.h(this.gmH, e.d.cp_cont_d);
                al.j(this.gmH, e.d.cp_bg_line_d);
                this.gmH.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.y(i, e.f.icon_floor_arrow_n), (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public View bof() {
        View inflate = LayoutInflater.from(this.mContext).inflate(e.h.new_sub_pb_list_expand_view, (ViewGroup) null);
        inflate.setTag(new a(this.mContext, inflate));
        return inflate;
    }

    public View oH() {
        b bVar = new b();
        View inflate = LayoutInflater.from(this.mContext).inflate(e.h.new_sub_pb_list_item, (ViewGroup) null);
        bVar.rootView = inflate;
        bVar.gmI = (LinearLayout) inflate.findViewById(e.g.sub_pb_item_columnlayout);
        if (this.aFB) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.gmI.getLayoutParams();
            layoutParams.topMargin = l.h(this.mContext, e.C0210e.ds8);
            layoutParams.bottomMargin = l.h(this.mContext, e.C0210e.ds8);
            bVar.gmI.setLayoutParams(layoutParams);
        }
        bVar.cFR = (TextView) inflate.findViewById(e.g.manage_btn);
        bVar.gax = (TbRichTextView) inflate.findViewById(e.g.new_sub_pb_list_richText);
        bVar.gmJ = inflate.findViewById(e.g.divide_bottom_view);
        bVar.gax.getLayoutStrategy().setSupportNoImage();
        if (!this.aFB) {
            bVar.gax.getLayoutStrategy().setLineSpacing(l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.tbds12), 1.0f);
            bVar.gax.getLayoutStrategy().gT(0);
            bVar.gax.getLayoutStrategy().gR(l.h(this.mContext, e.C0210e.tbds20));
            bVar.gax.getLayoutStrategy().gS(l.h(this.mContext, e.C0210e.tbds3));
        }
        bVar.gax.setSubPbPost(true);
        bVar.gax.setTextColor(al.getColor(e.d.cp_cont_f));
        bVar.gax.setTextSize(TbConfig.getContentSizeOfLzl());
        bVar.gax.setTextCenter(true);
        bVar.gax.setOnClickListener(this.mCommonClickListener);
        bVar.cFR.setOnClickListener(this.gmD);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(e.g.tag_holder, bVar);
        inflate.setTag(sparseArray);
        return inflate;
    }

    public void a(b bVar, PostData postData, boolean z, boolean z2, boolean z3) {
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        SparseArray sparseArray;
        if (bVar != null && postData != null) {
            if (!postData.hqs && (this.mContext instanceof com.baidu.tieba.pb.pb.a)) {
                com.baidu.tieba.pb.pb.a aVar = (com.baidu.tieba.pb.pb.a) this.mContext;
                postData.a(aVar.getPageContext(), postData.zT() != null && aVar.tg(postData.zT().getUserId()));
            }
            if (z3) {
                al.j(bVar.rootView, e.d.cp_bg_line_b);
            } else {
                bVar.rootView.setBackgroundResource(0);
            }
            if (postData.bET()) {
                bVar.gmJ.setVisibility(0);
            } else {
                bVar.gmJ.setVisibility(8);
            }
            bVar.gax.setPadding(0, 0, 0, 0);
            if (postData.zT() != null) {
                String name_show = postData.zT().getName_show();
                String userId = postData.zT().getUserId();
                SparseArray sparseArray2 = (SparseArray) bVar.rootView.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    bVar.rootView.setTag(sparseArray2);
                    bVar.gax.setTag(sparseArray2);
                }
                sparseArray2.put(e.g.tag_photo_username, name_show);
                sparseArray2.put(e.g.tag_photo_userid, userId);
                sparseArray2.put(e.g.tag_clip_board, postData);
                sparseArray2.put(e.g.tag_is_subpb, true);
            }
            bVar.gax.setLinkTextColor(al.getColor(e.d.cp_link_tip_c));
            bVar.gax.setTextColor(al.getColor(e.d.cp_cont_f));
            a(postData, this.aFB);
            TbRichText bEU = postData.bEU();
            if (bEU != null) {
                bVar.gax.setVoiceViewRes(e.h.voice_play_btn_new);
                bVar.gax.setIsFromCDN(this.mIsFromCDN);
                if (bVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                    bEU.isChanged = true;
                }
                bVar.gax.setText(bEU);
            }
            String userId2 = postData.zT().getUserId();
            if (this.gmE != 0) {
                boolean z9 = this.gmE != 1002;
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
            if (!this.gmF) {
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
            bVar.cFR.setVisibility(8);
            SparseArray sparseArray3 = (SparseArray) bVar.rootView.getTag();
            if (sparseArray3 == null) {
                SparseArray sparseArray4 = new SparseArray();
                bVar.rootView.setTag(sparseArray4);
                bVar.gax.setTag(sparseArray4);
                sparseArray = sparseArray4;
            } else {
                sparseArray = sparseArray3;
            }
            sparseArray.put(e.g.tag_subpb_main_floor_post_id, this.mPostId);
            if (z5) {
                sparseArray.put(e.g.tag_should_manage_visible, true);
                sparseArray.put(e.g.tag_manage_user_identity, Integer.valueOf(this.gmE));
                if (postData.zT() != null) {
                    sparseArray.put(e.g.tag_forbid_user_name, postData.zT().getUserName());
                    sparseArray.put(e.g.tag_forbid_user_name_show, postData.zT().getName_show());
                    sparseArray.put(e.g.tag_forbid_user_portrait, postData.zT().getPortrait());
                }
                sparseArray.put(e.g.tag_forbid_user_post_id, postData.getId());
            } else {
                sparseArray.put(e.g.tag_should_manage_visible, false);
            }
            sparseArray.put(e.g.tag_forbid_user_post_id, postData.getId());
            sparseArray.put(e.g.tag_clip_board, postData);
            if (z6) {
                if (this.bOk != null) {
                    sparseArray.put(e.g.tag_user_mute_visible, true);
                    sparseArray.put(e.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (postData.zT() != null) {
                        sparseArray.put(e.g.tag_user_mute_mute_userid, postData.zT().getUserId());
                        sparseArray.put(e.g.tag_user_mute_mute_username, postData.zT().getUserName());
                        sparseArray.put(e.g.tag_user_mute_mute_nameshow, postData.zT().getName_show());
                    }
                    if (this.bOk.getId() != null) {
                        sparseArray.put(e.g.tag_user_mute_thread_id, this.bOk.getId());
                    }
                    sparseArray.put(e.g.tag_user_mute_post_id, postData.getId());
                }
            } else {
                sparseArray.put(e.g.tag_user_mute_visible, false);
            }
            if (z8) {
                sparseArray.put(e.g.tag_should_delete_visible, true);
                sparseArray.put(e.g.tag_manage_user_identity, Integer.valueOf(this.gmE));
                sparseArray.put(e.g.tag_del_post_is_self, Boolean.valueOf(z7));
                sparseArray.put(e.g.tag_del_post_type, 2);
                sparseArray.put(e.g.tag_del_post_id, postData.getId());
            } else {
                sparseArray.put(e.g.tag_should_delete_visible, false);
            }
            if (this.aFB && z2 && this.aZs) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.gmI.getLayoutParams();
                layoutParams.topMargin = l.h(this.mContext, e.C0210e.ds32);
                layoutParams.bottomMargin = l.h(this.mContext, e.C0210e.ds8);
                bVar.gmI.setLayoutParams(layoutParams);
            }
            if (this.aFB && !z2) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.gmI.getLayoutParams();
                layoutParams2.topMargin = l.h(this.mContext, e.C0210e.ds8);
                layoutParams2.bottomMargin = l.h(this.mContext, e.C0210e.ds8);
                bVar.gmI.setLayoutParams(layoutParams2);
            }
            bVar.cFR.setTag(sparseArray);
            bVar.gax.setTag(sparseArray);
            bVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            bVar.gax.setOnLongClickListener(this.aTZ);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(PostData postData, boolean z) {
        TbRichText bEU;
        SpannableStringBuilder SE;
        TbRichTextData tbRichTextData;
        String str;
        String str2;
        SpannableStringBuilder SE2;
        if (postData != null && (bEU = postData.bEU()) != null) {
            ArrayList<TbRichTextData> Sx = bEU.Sx();
            if (!v.I(Sx)) {
                if (z) {
                    TbRichTextData tbRichTextData2 = Sx.get(Sx.size() - 1);
                    int type = tbRichTextData2 != null ? tbRichTextData2.getType() : -1;
                    if (type == 1) {
                        String str3 = "   " + ao.M(postData.getTime());
                        if (Sx.size() > 1) {
                            if ((Sx.get(Sx.size() + (-2)) != null ? Sx.get(Sx.size() - 2).getType() : -1) != type) {
                                str2 = ao.M(postData.getTime());
                                SE2 = tbRichTextData2.SE();
                                if (bEU.hasAppendTime && SE2 != 0 && bEU.appendLength <= SE2.length()) {
                                    SE2.delete(SE2.length() - bEU.appendLength, SE2.length());
                                }
                                String fT = ao.fT(str2);
                                if (SE2 != null) {
                                    SE2.append((CharSequence) fT);
                                }
                                bEU.hasAppendTime = true;
                                bEU.appendLength = fT.length();
                                tbRichTextData = tbRichTextData2;
                                str = fT;
                            }
                        }
                        str2 = str3;
                        SE2 = tbRichTextData2.SE();
                        if (bEU.hasAppendTime) {
                            SE2.delete(SE2.length() - bEU.appendLength, SE2.length());
                        }
                        String fT2 = ao.fT(str2);
                        if (SE2 != null) {
                        }
                        bEU.hasAppendTime = true;
                        bEU.appendLength = fT2.length();
                        tbRichTextData = tbRichTextData2;
                        str = fT2;
                    } else if (bEU.hasAppendTime) {
                        tbRichTextData = tbRichTextData2;
                        str = "";
                    } else {
                        String M = ao.M(postData.getTime());
                        tbRichTextData = new TbRichTextData(1);
                        str = ao.fT(M);
                        tbRichTextData.append(str);
                        bEU.hasAppendTime = true;
                        bEU.appendLength = str.length();
                        Sx.add(tbRichTextData);
                    }
                    SpannableStringBuilder SE3 = tbRichTextData.SE();
                    if (SE3 != null && str.length() <= SE3.length()) {
                        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(TbConfig.getContentSizeOfLzl());
                        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(al.getColor(e.d.cp_cont_d));
                        SE3.setSpan(absoluteSizeSpan, SE3.length() - str.length(), SE3.length(), 33);
                        SE3.setSpan(foregroundColorSpan, SE3.length() - str.length(), SE3.length(), 33);
                        return;
                    }
                    return;
                }
                TbRichTextData tbRichTextData3 = Sx.get(Sx.size() - 1);
                if (bEU.hasAppendTime && tbRichTextData3 != null && (SE = tbRichTextData3.SE()) != null && bEU.appendLength <= SE.length()) {
                    SE.delete(SE.length() - bEU.appendLength, SE.length());
                }
                bEU.hasAppendTime = false;
                bEU.appendLength = 0;
            }
        }
    }

    public void tI(String str) {
        this.mPostId = str;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aTZ = onLongClickListener;
    }

    public void s(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }
}
