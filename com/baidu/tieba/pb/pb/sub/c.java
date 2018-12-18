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
    private bb bNv;
    protected Context mContext;
    protected ArrayList<PostData> mData = null;
    protected View.OnClickListener giJ = null;
    protected int giK = 0;
    protected boolean giL = false;
    protected boolean giM = false;
    protected boolean ddJ = false;
    private boolean mIsFromCDN = true;
    private boolean aEY = false;
    private boolean aYF = false;
    private String mPostId = "";
    private int mSelectedPosition = -1;
    private View.OnLongClickListener aTo = null;
    private View.OnClickListener mCommonClickListener = null;

    /* loaded from: classes6.dex */
    public static class b {
        public TextView cEg;
        public TbRichTextView fWI;
        public LinearLayout giO;
        public View giP;
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
        this.bNv = bbVar;
    }

    public void M(View.OnClickListener onClickListener) {
        this.giJ = onClickListener;
    }

    public void B(int i, boolean z) {
        this.giK = i;
        this.giL = z;
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
            if (postData.getType() == PostData.hlq) {
                view = bmL();
            } else {
                view = oD();
            }
        }
        if ((view.getTag() instanceof a) && postData.getType() != PostData.hlq) {
            view = oD();
        }
        if ((view.getTag() instanceof SparseArray) && postData.getType() == PostData.hlq) {
            view = bmL();
        }
        if ((view.getTag() instanceof SparseArray) && (bVar = (b) ((SparseArray) view.getTag()).get(e.g.tag_holder)) != null && postData != null) {
            boolean z = !this.ddJ && i + 1 >= getCount();
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
        public View byP;
        public TextView giN;
        public View mRootView;
        private int mSkinType = 3;

        public a(Context context, View view) {
            this.mRootView = view;
            this.byP = view.findViewById(e.g.divider_line);
            this.giN = (TextView) view.findViewById(e.g.center_reply_text);
            this.giN.setTextSize(0, TbConfig.getContentSizeOfLzl());
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }

        public void onChangeSkinType(int i) {
            if (i != this.mSkinType) {
                al.j(this.byP, e.d.cp_cont_d);
                al.h(this.giN, e.d.cp_cont_d);
                al.j(this.giN, e.d.cp_bg_line_d);
                this.giN.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.y(i, e.f.icon_floor_arrow_n), (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public View bmL() {
        View inflate = LayoutInflater.from(this.mContext).inflate(e.h.new_sub_pb_list_expand_view, (ViewGroup) null);
        inflate.setTag(new a(this.mContext, inflate));
        return inflate;
    }

    public View oD() {
        b bVar = new b();
        View inflate = LayoutInflater.from(this.mContext).inflate(e.h.new_sub_pb_list_item, (ViewGroup) null);
        bVar.rootView = inflate;
        bVar.giO = (LinearLayout) inflate.findViewById(e.g.sub_pb_item_columnlayout);
        if (this.aEY) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.giO.getLayoutParams();
            layoutParams.topMargin = l.h(this.mContext, e.C0210e.ds8);
            layoutParams.bottomMargin = l.h(this.mContext, e.C0210e.ds8);
            bVar.giO.setLayoutParams(layoutParams);
        }
        bVar.cEg = (TextView) inflate.findViewById(e.g.manage_btn);
        bVar.fWI = (TbRichTextView) inflate.findViewById(e.g.new_sub_pb_list_richText);
        bVar.giP = inflate.findViewById(e.g.divide_bottom_view);
        bVar.fWI.getLayoutStrategy().setSupportNoImage();
        if (!this.aEY) {
            bVar.fWI.getLayoutStrategy().setLineSpacing(l.h(TbadkCoreApplication.getInst().getContext(), e.C0210e.tbds12), 1.0f);
            bVar.fWI.getLayoutStrategy().gS(0);
            bVar.fWI.getLayoutStrategy().gQ(l.h(this.mContext, e.C0210e.tbds20));
            bVar.fWI.getLayoutStrategy().gR(l.h(this.mContext, e.C0210e.tbds3));
        }
        bVar.fWI.setSubPbPost(true);
        bVar.fWI.setTextColor(al.getColor(e.d.cp_cont_f));
        bVar.fWI.setTextSize(TbConfig.getContentSizeOfLzl());
        bVar.fWI.setTextCenter(true);
        bVar.fWI.setOnClickListener(this.mCommonClickListener);
        bVar.cEg.setOnClickListener(this.giJ);
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
            if (!postData.hmc && (this.mContext instanceof com.baidu.tieba.pb.pb.a)) {
                com.baidu.tieba.pb.pb.a aVar = (com.baidu.tieba.pb.pb.a) this.mContext;
                postData.a(aVar.getPageContext(), postData.zG() != null && aVar.sN(postData.zG().getUserId()));
            }
            if (z3) {
                al.j(bVar.rootView, e.d.cp_bg_line_b);
            } else {
                bVar.rootView.setBackgroundResource(0);
            }
            if (postData.bDs()) {
                bVar.giP.setVisibility(0);
            } else {
                bVar.giP.setVisibility(8);
            }
            bVar.fWI.setPadding(0, 0, 0, 0);
            if (postData.zG() != null) {
                String name_show = postData.zG().getName_show();
                String userId = postData.zG().getUserId();
                SparseArray sparseArray2 = (SparseArray) bVar.rootView.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    bVar.rootView.setTag(sparseArray2);
                    bVar.fWI.setTag(sparseArray2);
                }
                sparseArray2.put(e.g.tag_photo_username, name_show);
                sparseArray2.put(e.g.tag_photo_userid, userId);
                sparseArray2.put(e.g.tag_clip_board, postData);
                sparseArray2.put(e.g.tag_is_subpb, true);
            }
            bVar.fWI.setLinkTextColor(al.getColor(e.d.cp_link_tip_c));
            bVar.fWI.setTextColor(al.getColor(e.d.cp_cont_f));
            a(postData, this.aEY);
            TbRichText bDt = postData.bDt();
            if (bDt != null) {
                bVar.fWI.setVoiceViewRes(e.h.voice_play_btn_new);
                bVar.fWI.setIsFromCDN(this.mIsFromCDN);
                if (bVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                    bDt.isChanged = true;
                }
                bVar.fWI.setText(bDt);
            }
            String userId2 = postData.zG().getUserId();
            if (this.giK != 0) {
                boolean z9 = this.giK != 1002;
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
            if (!this.giL) {
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
            bVar.cEg.setVisibility(8);
            SparseArray sparseArray3 = (SparseArray) bVar.rootView.getTag();
            if (sparseArray3 == null) {
                SparseArray sparseArray4 = new SparseArray();
                bVar.rootView.setTag(sparseArray4);
                bVar.fWI.setTag(sparseArray4);
                sparseArray = sparseArray4;
            } else {
                sparseArray = sparseArray3;
            }
            sparseArray.put(e.g.tag_subpb_main_floor_post_id, this.mPostId);
            if (z5) {
                sparseArray.put(e.g.tag_should_manage_visible, true);
                sparseArray.put(e.g.tag_manage_user_identity, Integer.valueOf(this.giK));
                if (postData.zG() != null) {
                    sparseArray.put(e.g.tag_forbid_user_name, postData.zG().getUserName());
                    sparseArray.put(e.g.tag_forbid_user_name_show, postData.zG().getName_show());
                    sparseArray.put(e.g.tag_forbid_user_portrait, postData.zG().getPortrait());
                }
                sparseArray.put(e.g.tag_forbid_user_post_id, postData.getId());
            } else {
                sparseArray.put(e.g.tag_should_manage_visible, false);
            }
            sparseArray.put(e.g.tag_forbid_user_post_id, postData.getId());
            sparseArray.put(e.g.tag_clip_board, postData);
            if (z6) {
                if (this.bNv != null) {
                    sparseArray.put(e.g.tag_user_mute_visible, true);
                    sparseArray.put(e.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (postData.zG() != null) {
                        sparseArray.put(e.g.tag_user_mute_mute_userid, postData.zG().getUserId());
                        sparseArray.put(e.g.tag_user_mute_mute_username, postData.zG().getUserName());
                        sparseArray.put(e.g.tag_user_mute_mute_nameshow, postData.zG().getName_show());
                    }
                    if (this.bNv.getId() != null) {
                        sparseArray.put(e.g.tag_user_mute_thread_id, this.bNv.getId());
                    }
                    sparseArray.put(e.g.tag_user_mute_post_id, postData.getId());
                }
            } else {
                sparseArray.put(e.g.tag_user_mute_visible, false);
            }
            if (z8) {
                sparseArray.put(e.g.tag_should_delete_visible, true);
                sparseArray.put(e.g.tag_manage_user_identity, Integer.valueOf(this.giK));
                sparseArray.put(e.g.tag_del_post_is_self, Boolean.valueOf(z7));
                sparseArray.put(e.g.tag_del_post_type, 2);
                sparseArray.put(e.g.tag_del_post_id, postData.getId());
            } else {
                sparseArray.put(e.g.tag_should_delete_visible, false);
            }
            if (this.aEY && z2 && this.aYF) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.giO.getLayoutParams();
                layoutParams.topMargin = l.h(this.mContext, e.C0210e.ds32);
                layoutParams.bottomMargin = l.h(this.mContext, e.C0210e.ds8);
                bVar.giO.setLayoutParams(layoutParams);
            }
            if (this.aEY && !z2) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.giO.getLayoutParams();
                layoutParams2.topMargin = l.h(this.mContext, e.C0210e.ds8);
                layoutParams2.bottomMargin = l.h(this.mContext, e.C0210e.ds8);
                bVar.giO.setLayoutParams(layoutParams2);
            }
            bVar.cEg.setTag(sparseArray);
            bVar.fWI.setTag(sparseArray);
            bVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            bVar.fWI.setOnLongClickListener(this.aTo);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(PostData postData, boolean z) {
        TbRichText bDt;
        SpannableStringBuilder Sg;
        TbRichTextData tbRichTextData;
        String str;
        String str2;
        SpannableStringBuilder Sg2;
        if (postData != null && (bDt = postData.bDt()) != null) {
            ArrayList<TbRichTextData> RZ = bDt.RZ();
            if (!v.I(RZ)) {
                if (z) {
                    TbRichTextData tbRichTextData2 = RZ.get(RZ.size() - 1);
                    int type = tbRichTextData2 != null ? tbRichTextData2.getType() : -1;
                    if (type == 1) {
                        String str3 = "   " + ao.L(postData.getTime());
                        if (RZ.size() > 1) {
                            if ((RZ.get(RZ.size() + (-2)) != null ? RZ.get(RZ.size() - 2).getType() : -1) != type) {
                                str2 = ao.L(postData.getTime());
                                Sg2 = tbRichTextData2.Sg();
                                if (bDt.hasAppendTime && Sg2 != 0 && bDt.appendLength <= Sg2.length()) {
                                    Sg2.delete(Sg2.length() - bDt.appendLength, Sg2.length());
                                }
                                String fG = ao.fG(str2);
                                if (Sg2 != null) {
                                    Sg2.append((CharSequence) fG);
                                }
                                bDt.hasAppendTime = true;
                                bDt.appendLength = fG.length();
                                tbRichTextData = tbRichTextData2;
                                str = fG;
                            }
                        }
                        str2 = str3;
                        Sg2 = tbRichTextData2.Sg();
                        if (bDt.hasAppendTime) {
                            Sg2.delete(Sg2.length() - bDt.appendLength, Sg2.length());
                        }
                        String fG2 = ao.fG(str2);
                        if (Sg2 != null) {
                        }
                        bDt.hasAppendTime = true;
                        bDt.appendLength = fG2.length();
                        tbRichTextData = tbRichTextData2;
                        str = fG2;
                    } else if (bDt.hasAppendTime) {
                        tbRichTextData = tbRichTextData2;
                        str = "";
                    } else {
                        String L = ao.L(postData.getTime());
                        tbRichTextData = new TbRichTextData(1);
                        str = ao.fG(L);
                        tbRichTextData.append(str);
                        bDt.hasAppendTime = true;
                        bDt.appendLength = str.length();
                        RZ.add(tbRichTextData);
                    }
                    SpannableStringBuilder Sg3 = tbRichTextData.Sg();
                    if (Sg3 != null && str.length() <= Sg3.length()) {
                        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(TbConfig.getContentSizeOfLzl());
                        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(al.getColor(e.d.cp_cont_d));
                        Sg3.setSpan(absoluteSizeSpan, Sg3.length() - str.length(), Sg3.length(), 33);
                        Sg3.setSpan(foregroundColorSpan, Sg3.length() - str.length(), Sg3.length(), 33);
                        return;
                    }
                    return;
                }
                TbRichTextData tbRichTextData3 = RZ.get(RZ.size() - 1);
                if (bDt.hasAppendTime && tbRichTextData3 != null && (Sg = tbRichTextData3.Sg()) != null && bDt.appendLength <= Sg.length()) {
                    Sg.delete(Sg.length() - bDt.appendLength, Sg.length());
                }
                bDt.hasAppendTime = false;
                bDt.appendLength = 0;
            }
        }
    }

    public void tp(String str) {
        this.mPostId = str;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.aTo = onLongClickListener;
    }

    public void s(View.OnClickListener onClickListener) {
        this.mCommonClickListener = onClickListener;
    }
}
