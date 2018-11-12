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
    private bb bJG;
    protected Context mContext;
    protected ArrayList<PostData> mData = null;
    protected View.OnClickListener gbR = null;
    protected int gbS = 0;
    protected boolean gbT = false;
    protected boolean gbU = false;
    protected boolean cWY = false;
    private boolean mIsFromCDN = true;
    private boolean aBy = false;
    private boolean aVi = false;
    private String mPostId = "";
    private int mSelectedPosition = -1;
    private View.OnLongClickListener aPP = null;
    private View.OnClickListener mCommonClickListener = null;

    /* loaded from: classes6.dex */
    public static class b {
        public TextView cAo;
        public TbRichTextView fPS;
        public LinearLayout gbW;
        public View gbX;
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
        this.bJG = bbVar;
    }

    public void M(View.OnClickListener onClickListener) {
        this.gbR = onClickListener;
    }

    public void B(int i, boolean z) {
        this.gbS = i;
        this.gbT = z;
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
            if (postData.getType() == PostData.hew) {
                view = bkT();
            } else {
                view = oE();
            }
        }
        if ((view.getTag() instanceof a) && postData.getType() != PostData.hew) {
            view = oE();
        }
        if ((view.getTag() instanceof SparseArray) && postData.getType() == PostData.hew) {
            view = bkT();
        }
        if ((view.getTag() instanceof SparseArray) && (bVar = (b) ((SparseArray) view.getTag()).get(e.g.tag_holder)) != null && postData != null) {
            boolean z = !this.cWY && i + 1 >= getCount();
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
        public View bvs;
        public TextView gbV;
        public View mRootView;
        private int mSkinType = 3;

        public a(Context context, View view) {
            this.mRootView = view;
            this.bvs = view.findViewById(e.g.divider_line);
            this.gbV = (TextView) view.findViewById(e.g.center_reply_text);
            this.gbV.setTextSize(0, TbConfig.getContentSizeOfLzl());
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }

        public void onChangeSkinType(int i) {
            if (i != this.mSkinType) {
                al.j(this.bvs, e.d.cp_cont_d);
                al.h(this.gbV, e.d.cp_cont_d);
                al.j(this.gbV, e.d.cp_bg_line_d);
                this.gbV.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.x(i, e.f.icon_floor_arrow_n), (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public View bkT() {
        View inflate = LayoutInflater.from(this.mContext).inflate(e.h.new_sub_pb_list_expand_view, (ViewGroup) null);
        inflate.setTag(new a(this.mContext, inflate));
        return inflate;
    }

    public View oE() {
        b bVar = new b();
        View inflate = LayoutInflater.from(this.mContext).inflate(e.h.new_sub_pb_list_item, (ViewGroup) null);
        bVar.rootView = inflate;
        bVar.gbW = (LinearLayout) inflate.findViewById(e.g.sub_pb_item_columnlayout);
        if (this.aBy) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.gbW.getLayoutParams();
            layoutParams.topMargin = l.h(this.mContext, e.C0200e.ds8);
            layoutParams.bottomMargin = l.h(this.mContext, e.C0200e.ds8);
            bVar.gbW.setLayoutParams(layoutParams);
        }
        bVar.cAo = (TextView) inflate.findViewById(e.g.manage_btn);
        bVar.fPS = (TbRichTextView) inflate.findViewById(e.g.new_sub_pb_list_richText);
        bVar.gbX = inflate.findViewById(e.g.divide_bottom_view);
        bVar.fPS.getLayoutStrategy().setSupportNoImage();
        if (!this.aBy) {
            bVar.fPS.getLayoutStrategy().setLineSpacing(l.h(TbadkCoreApplication.getInst().getContext(), e.C0200e.tbds12), 1.0f);
            bVar.fPS.getLayoutStrategy().gE(0);
            bVar.fPS.getLayoutStrategy().gC(l.h(this.mContext, e.C0200e.tbds20));
            bVar.fPS.getLayoutStrategy().gD(l.h(this.mContext, e.C0200e.tbds3));
        }
        bVar.fPS.setSubPbPost(true);
        bVar.fPS.setTextColor(al.getColor(e.d.cp_cont_f));
        bVar.fPS.setTextSize(TbConfig.getContentSizeOfLzl());
        bVar.fPS.setTextCenter(true);
        bVar.fPS.setOnClickListener(this.mCommonClickListener);
        bVar.cAo.setOnClickListener(this.gbR);
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
            if (!postData.hfi && (this.mContext instanceof com.baidu.tieba.pb.pb.a)) {
                com.baidu.tieba.pb.pb.a aVar = (com.baidu.tieba.pb.pb.a) this.mContext;
                postData.a(aVar.getPageContext(), postData.yC() != null && aVar.sk(postData.yC().getUserId()));
            }
            if (z3) {
                al.j(bVar.rootView, e.d.cp_bg_line_b);
            } else {
                bVar.rootView.setBackgroundResource(0);
            }
            if (postData.bBy()) {
                bVar.gbX.setVisibility(0);
            } else {
                bVar.gbX.setVisibility(8);
            }
            bVar.fPS.setPadding(0, 0, 0, 0);
            if (postData.yC() != null) {
                String name_show = postData.yC().getName_show();
                String userId = postData.yC().getUserId();
                SparseArray sparseArray2 = (SparseArray) bVar.rootView.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    bVar.rootView.setTag(sparseArray2);
                    bVar.fPS.setTag(sparseArray2);
                }
                sparseArray2.put(e.g.tag_photo_username, name_show);
                sparseArray2.put(e.g.tag_photo_userid, userId);
                sparseArray2.put(e.g.tag_clip_board, postData);
                sparseArray2.put(e.g.tag_is_subpb, true);
            }
            bVar.fPS.setLinkTextColor(al.getColor(e.d.cp_link_tip_c));
            bVar.fPS.setTextColor(al.getColor(e.d.cp_cont_f));
            a(postData, this.aBy);
            TbRichText bBz = postData.bBz();
            if (bBz != null) {
                bVar.fPS.setVoiceViewRes(e.h.voice_play_btn_new);
                bVar.fPS.setIsFromCDN(this.mIsFromCDN);
                if (bVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                    bBz.isChanged = true;
                }
                bVar.fPS.setText(bBz);
            }
            String userId2 = postData.yC().getUserId();
            if (this.gbS != 0) {
                boolean z9 = this.gbS != 1002;
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
            if (!this.gbT) {
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
            bVar.cAo.setVisibility(8);
            SparseArray sparseArray3 = (SparseArray) bVar.rootView.getTag();
            if (sparseArray3 == null) {
                SparseArray sparseArray4 = new SparseArray();
                bVar.rootView.setTag(sparseArray4);
                bVar.fPS.setTag(sparseArray4);
                sparseArray = sparseArray4;
            } else {
                sparseArray = sparseArray3;
            }
            sparseArray.put(e.g.tag_subpb_main_floor_post_id, this.mPostId);
            if (z5) {
                sparseArray.put(e.g.tag_should_manage_visible, true);
                sparseArray.put(e.g.tag_manage_user_identity, Integer.valueOf(this.gbS));
                if (postData.yC() != null) {
                    sparseArray.put(e.g.tag_forbid_user_name, postData.yC().getUserName());
                    sparseArray.put(e.g.tag_forbid_user_name_show, postData.yC().getName_show());
                    sparseArray.put(e.g.tag_forbid_user_portrait, postData.yC().getPortrait());
                }
                sparseArray.put(e.g.tag_forbid_user_post_id, postData.getId());
            } else {
                sparseArray.put(e.g.tag_should_manage_visible, false);
            }
            sparseArray.put(e.g.tag_forbid_user_post_id, postData.getId());
            sparseArray.put(e.g.tag_clip_board, postData);
            if (z6) {
                if (this.bJG != null) {
                    sparseArray.put(e.g.tag_user_mute_visible, true);
                    sparseArray.put(e.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (postData.yC() != null) {
                        sparseArray.put(e.g.tag_user_mute_mute_userid, postData.yC().getUserId());
                        sparseArray.put(e.g.tag_user_mute_mute_username, postData.yC().getUserName());
                        sparseArray.put(e.g.tag_user_mute_mute_nameshow, postData.yC().getName_show());
                    }
                    if (this.bJG.getId() != null) {
                        sparseArray.put(e.g.tag_user_mute_thread_id, this.bJG.getId());
                    }
                    sparseArray.put(e.g.tag_user_mute_post_id, postData.getId());
                }
            } else {
                sparseArray.put(e.g.tag_user_mute_visible, false);
            }
            if (z8) {
                sparseArray.put(e.g.tag_should_delete_visible, true);
                sparseArray.put(e.g.tag_manage_user_identity, Integer.valueOf(this.gbS));
                sparseArray.put(e.g.tag_del_post_is_self, Boolean.valueOf(z7));
                sparseArray.put(e.g.tag_del_post_type, 2);
                sparseArray.put(e.g.tag_del_post_id, postData.getId());
            } else {
                sparseArray.put(e.g.tag_should_delete_visible, false);
            }
            if (this.aBy && z2 && this.aVi) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.gbW.getLayoutParams();
                layoutParams.topMargin = l.h(this.mContext, e.C0200e.ds32);
                layoutParams.bottomMargin = l.h(this.mContext, e.C0200e.ds8);
                bVar.gbW.setLayoutParams(layoutParams);
            }
            if (this.aBy && !z2) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.gbW.getLayoutParams();
                layoutParams2.topMargin = l.h(this.mContext, e.C0200e.ds8);
                layoutParams2.bottomMargin = l.h(this.mContext, e.C0200e.ds8);
                bVar.gbW.setLayoutParams(layoutParams2);
            }
            bVar.cAo.setTag(sparseArray);
            bVar.fPS.setTag(sparseArray);
            bVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            bVar.fPS.setOnLongClickListener(this.aPP);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(PostData postData, boolean z) {
        TbRichText bBz;
        SpannableStringBuilder Ra;
        TbRichTextData tbRichTextData;
        String str;
        String str2;
        SpannableStringBuilder Ra2;
        if (postData != null && (bBz = postData.bBz()) != null) {
            ArrayList<TbRichTextData> QT = bBz.QT();
            if (!v.I(QT)) {
                if (z) {
                    TbRichTextData tbRichTextData2 = QT.get(QT.size() - 1);
                    int type = tbRichTextData2 != null ? tbRichTextData2.getType() : -1;
                    if (type == 1) {
                        String str3 = "   " + ao.E(postData.getTime());
                        if (QT.size() > 1) {
                            if ((QT.get(QT.size() + (-2)) != null ? QT.get(QT.size() - 2).getType() : -1) != type) {
                                str2 = ao.E(postData.getTime());
                                Ra2 = tbRichTextData2.Ra();
                                if (bBz.hasAppendTime && Ra2 != 0 && bBz.appendLength <= Ra2.length()) {
                                    Ra2.delete(Ra2.length() - bBz.appendLength, Ra2.length());
                                }
                                String fo = ao.fo(str2);
                                if (Ra2 != null) {
                                    Ra2.append((CharSequence) fo);
                                }
                                bBz.hasAppendTime = true;
                                bBz.appendLength = fo.length();
                                tbRichTextData = tbRichTextData2;
                                str = fo;
                            }
                        }
                        str2 = str3;
                        Ra2 = tbRichTextData2.Ra();
                        if (bBz.hasAppendTime) {
                            Ra2.delete(Ra2.length() - bBz.appendLength, Ra2.length());
                        }
                        String fo2 = ao.fo(str2);
                        if (Ra2 != null) {
                        }
                        bBz.hasAppendTime = true;
                        bBz.appendLength = fo2.length();
                        tbRichTextData = tbRichTextData2;
                        str = fo2;
                    } else if (bBz.hasAppendTime) {
                        tbRichTextData = tbRichTextData2;
                        str = "";
                    } else {
                        String E = ao.E(postData.getTime());
                        tbRichTextData = new TbRichTextData(1);
                        str = ao.fo(E);
                        tbRichTextData.append(str);
                        bBz.hasAppendTime = true;
                        bBz.appendLength = str.length();
                        QT.add(tbRichTextData);
                    }
                    SpannableStringBuilder Ra3 = tbRichTextData.Ra();
                    if (Ra3 != null && str.length() <= Ra3.length()) {
                        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(TbConfig.getContentSizeOfLzl());
                        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(al.getColor(e.d.cp_cont_d));
                        Ra3.setSpan(absoluteSizeSpan, Ra3.length() - str.length(), Ra3.length(), 33);
                        Ra3.setSpan(foregroundColorSpan, Ra3.length() - str.length(), Ra3.length(), 33);
                        return;
                    }
                    return;
                }
                TbRichTextData tbRichTextData3 = QT.get(QT.size() - 1);
                if (bBz.hasAppendTime && tbRichTextData3 != null && (Ra = tbRichTextData3.Ra()) != null && bBz.appendLength <= Ra.length()) {
                    Ra.delete(Ra.length() - bBz.appendLength, Ra.length());
                }
                bBz.hasAppendTime = false;
                bBz.appendLength = 0;
            }
        }
    }

    public void sN(String str) {
        this.mPostId = str;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aPP = onLongClickListener;
    }

    public void s(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }
}
