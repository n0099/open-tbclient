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
import com.baidu.tbadk.core.data.bj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class b extends BaseAdapter {
    private bj Np;
    protected Context mContext;
    protected View.OnClickListener iUk = null;
    protected int iUl = 0;
    protected boolean iUm = false;
    protected boolean fMV = false;
    private boolean mIsFromCDN = true;
    private boolean iUn = false;
    private boolean dsP = false;
    private String mPostId = "";
    private int mSelectedPosition = -1;
    private View.OnLongClickListener mOnLongClickListener = null;
    private View.OnClickListener ain = null;

    /* renamed from: com.baidu.tieba.pb.pb.sub.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0574b {
        public TextView fqh;
        public TbRichTextView iEW;
        public LinearLayout iUp;
        public View iUq;
        public int mSkinType = 3;
        public View rootView;
    }

    public b(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void setThreadData(bj bjVar) {
        this.Np = bjVar;
    }

    public void S(View.OnClickListener onClickListener) {
        this.iUk = onClickListener;
    }

    public void P(int i, boolean z) {
        this.iUl = i;
        this.iUm = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        return 0;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        return null;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        C0574b c0574b;
        PostData postData = null;
        if (getItem(i) instanceof PostData) {
            postData = (PostData) getItem(i);
        }
        if (view == null) {
            if (postData.getType() == PostData.kfq) {
                view = cqs();
            } else {
                view = createView();
            }
        }
        if ((view.getTag() instanceof a) && postData.getType() != PostData.kfq) {
            view = createView();
        }
        if ((view.getTag() instanceof SparseArray) && postData.getType() == PostData.kfq) {
            view = cqs();
        }
        if ((view.getTag() instanceof SparseArray) && (c0574b = (C0574b) ((SparseArray) view.getTag()).get(R.id.tag_holder)) != null && postData != null) {
            boolean z = !this.fMV && i + 1 >= getCount();
            boolean z2 = i == this.mSelectedPosition;
            a(c0574b, postData, !z, i == 0, z2);
            if (z2) {
                this.mSelectedPosition = -1;
            }
        }
        if (view.getTag() instanceof a) {
            ((a) view.getTag()).onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }
        return view;
    }

    /* loaded from: classes7.dex */
    public static class a {
        public View caf;
        public TextView iUo;
        public View mRootView;
        private int mSkinType = 3;

        public a(Context context, View view) {
            this.mRootView = view;
            this.caf = view.findViewById(R.id.divider_line);
            this.iUo = (TextView) view.findViewById(R.id.center_reply_text);
            this.iUo.setTextSize(0, TbConfig.getContentSizeOfLzl());
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }

        public void onChangeSkinType(int i) {
            if (i != this.mSkinType) {
                am.setBackgroundColor(this.caf, R.color.cp_cont_d);
                am.setViewTextColor(this.iUo, (int) R.color.cp_cont_d);
                am.setBackgroundColor(this.iUo, R.color.cp_bg_line_d);
                this.iUo.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.getDrawable(i, (int) R.drawable.icon_floor_arrow_n), (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public View cqs() {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.new_sub_pb_list_expand_view, (ViewGroup) null);
        inflate.setTag(new a(this.mContext, inflate));
        return inflate;
    }

    public View createView() {
        C0574b c0574b = new C0574b();
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.new_sub_pb_list_item, (ViewGroup) null);
        c0574b.rootView = inflate;
        c0574b.iUp = (LinearLayout) inflate.findViewById(R.id.sub_pb_item_columnlayout);
        if (this.iUn) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0574b.iUp.getLayoutParams();
            layoutParams.topMargin = l.getDimens(this.mContext, R.dimen.ds8);
            layoutParams.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
            c0574b.iUp.setLayoutParams(layoutParams);
        }
        c0574b.fqh = (TextView) inflate.findViewById(R.id.manage_btn);
        c0574b.iEW = (TbRichTextView) inflate.findViewById(R.id.new_sub_pb_list_richText);
        c0574b.iUq = inflate.findViewById(R.id.divide_bottom_view);
        c0574b.iEW.getLayoutStrategy().setSupportNoImage();
        if (!this.iUn) {
            c0574b.iEW.getLayoutStrategy().setLineSpacing(TbConfig.getContentLineSpaceOfLzl(), 1.0f);
            c0574b.iEW.getLayoutStrategy().na(0);
            c0574b.iEW.getLayoutStrategy().mY(l.getDimens(this.mContext, R.dimen.tbds20));
            c0574b.iEW.getLayoutStrategy().mZ(l.getDimens(this.mContext, R.dimen.tbds14));
        }
        c0574b.iEW.setSubPbPost(true);
        c0574b.iEW.setTextColor(am.getColor(R.color.cp_cont_f));
        c0574b.iEW.setTextSize(TbConfig.getContentSizeOfLzl());
        c0574b.iEW.setTextCenter(true);
        c0574b.iEW.setOnClickListener(this.ain);
        c0574b.fqh.setOnClickListener(this.iUk);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(R.id.tag_holder, c0574b);
        inflate.setTag(sparseArray);
        return inflate;
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x0311  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x031e  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x032b  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0338  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0345  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0255  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void a(C0574b c0574b, PostData postData, boolean z, boolean z2, boolean z3) {
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        SparseArray sparseArray;
        SparseArray sparseArray2;
        if (c0574b != null && postData != null) {
            if (!postData.kgf && (this.mContext instanceof com.baidu.tieba.pb.pb.a)) {
                com.baidu.tieba.pb.pb.a aVar = (com.baidu.tieba.pb.pb.a) this.mContext;
                postData.a(aVar.getPageContext(), postData.azX() != null && aVar.Fv(postData.azX().getUserId()));
            }
            if (z3) {
                am.setBackgroundColor(c0574b.rootView, R.color.cp_bg_line_c);
            } else {
                c0574b.rootView.setBackgroundResource(0);
            }
            if (postData.cJy()) {
                c0574b.iUq.setVisibility(0);
            } else {
                c0574b.iUq.setVisibility(8);
            }
            c0574b.iEW.setPadding(0, 0, 0, 0);
            if (postData.azX() != null) {
                String name_show = postData.azX().getName_show();
                String userId = postData.azX().getUserId();
                SparseArray sparseArray3 = (SparseArray) c0574b.rootView.getTag();
                if (sparseArray3 == null) {
                    sparseArray3 = new SparseArray();
                    c0574b.rootView.setTag(sparseArray3);
                    c0574b.iEW.setTag(sparseArray3);
                }
                sparseArray3.put(R.id.tag_photo_username, name_show);
                sparseArray3.put(R.id.tag_photo_userid, userId);
                sparseArray3.put(R.id.tag_clip_board, postData);
                sparseArray3.put(R.id.tag_is_subpb, true);
            }
            c0574b.iEW.setLinkTextColor(am.getColor(R.color.cp_link_tip_c));
            c0574b.iEW.setTextColor(am.getColor(R.color.cp_cont_f));
            b(postData, this.iUn);
            TbRichText cJz = postData.cJz();
            if (cJz != null) {
                c0574b.iEW.setVoiceViewRes(R.layout.voice_play_btn_new);
                c0574b.iEW.setIsFromCDN(this.mIsFromCDN);
                if (c0574b.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                    cJz.isChanged = true;
                }
                c0574b.iEW.setText(cJz);
            }
            boolean z8 = false;
            boolean z9 = false;
            boolean z10 = false;
            String userId2 = postData.azX().getUserId();
            if (this.iUl != 0) {
                if (this.iUl != 1002 && this.iUl != 3) {
                    z8 = true;
                }
                if (this.iUl != 3 && !this.Np.isBjh()) {
                    z9 = true;
                }
                if (userId2 != null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z8 = false;
                }
                if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                    boolean z11 = z9;
                    z4 = false;
                    z5 = z11;
                    if (this.iUm) {
                        z6 = false;
                    } else {
                        boolean z12 = !this.Np.isBjh() ? true : z5;
                        if (userId2 == null || !userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                            z6 = true;
                            z5 = z12;
                        } else {
                            z6 = false;
                            z5 = z12;
                        }
                    }
                    if (userId2 == null && userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                        z7 = true;
                        z10 = true;
                    } else {
                        z7 = z5;
                    }
                    c0574b.fqh.setVisibility(8);
                    sparseArray = (SparseArray) c0574b.rootView.getTag();
                    if (sparseArray != null) {
                        SparseArray sparseArray4 = new SparseArray();
                        c0574b.rootView.setTag(sparseArray4);
                        c0574b.iEW.setTag(sparseArray4);
                        sparseArray2 = sparseArray4;
                    } else {
                        sparseArray2 = sparseArray;
                    }
                    sparseArray2.put(R.id.tag_subpb_main_floor_post_id, this.mPostId);
                    if (!z4) {
                        sparseArray2.put(R.id.tag_should_manage_visible, true);
                        sparseArray2.put(R.id.tag_manage_user_identity, Integer.valueOf(this.iUl));
                        if (postData.azX() != null) {
                            sparseArray2.put(R.id.tag_forbid_user_name, postData.azX().getUserName());
                            sparseArray2.put(R.id.tag_forbid_user_name_show, postData.azX().getName_show());
                            sparseArray2.put(R.id.tag_forbid_user_portrait, postData.azX().getPortrait());
                        }
                        sparseArray2.put(R.id.tag_forbid_user_post_id, postData.getId());
                    } else {
                        sparseArray2.put(R.id.tag_should_manage_visible, false);
                    }
                    sparseArray2.put(R.id.tag_forbid_user_post_id, postData.getId());
                    sparseArray2.put(R.id.tag_clip_board, postData);
                    if (!z6) {
                        if (this.Np != null) {
                            sparseArray2.put(R.id.tag_user_mute_visible, true);
                            sparseArray2.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                            if (postData.azX() != null) {
                                sparseArray2.put(R.id.tag_user_mute_mute_userid, postData.azX().getUserId());
                                sparseArray2.put(R.id.tag_user_mute_mute_username, postData.azX().getUserName());
                                sparseArray2.put(R.id.tag_user_mute_mute_nameshow, postData.azX().getName_show());
                            }
                            if (this.Np.getId() != null) {
                                sparseArray2.put(R.id.tag_user_mute_thread_id, this.Np.getId());
                            }
                            sparseArray2.put(R.id.tag_user_mute_post_id, postData.getId());
                        }
                    } else {
                        sparseArray2.put(R.id.tag_user_mute_visible, false);
                    }
                    if (!z7) {
                        sparseArray2.put(R.id.tag_should_delete_visible, true);
                        sparseArray2.put(R.id.tag_manage_user_identity, Integer.valueOf(this.iUl));
                        sparseArray2.put(R.id.tag_del_post_is_self, Boolean.valueOf(z10));
                        sparseArray2.put(R.id.tag_del_post_type, 2);
                        sparseArray2.put(R.id.tag_del_post_id, postData.getId());
                    } else {
                        sparseArray2.put(R.id.tag_should_delete_visible, false);
                    }
                    if (this.iUn && z2 && this.dsP) {
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0574b.iUp.getLayoutParams();
                        layoutParams.topMargin = l.getDimens(this.mContext, R.dimen.ds32);
                        layoutParams.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
                        c0574b.iUp.setLayoutParams(layoutParams);
                    }
                    if (this.iUn && !z2) {
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) c0574b.iUp.getLayoutParams();
                        layoutParams2.topMargin = l.getDimens(this.mContext, R.dimen.ds8);
                        layoutParams2.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
                        c0574b.iUp.setLayoutParams(layoutParams2);
                    }
                    c0574b.fqh.setTag(sparseArray2);
                    c0574b.iEW.setTag(sparseArray2);
                    c0574b.mSkinType = TbadkCoreApplication.getInst().getSkinType();
                    c0574b.iEW.setOnLongClickListener(this.mOnLongClickListener);
                }
            }
            boolean z13 = z9;
            z4 = z8;
            z5 = z13;
            if (this.iUm) {
            }
            if (userId2 == null) {
            }
            z7 = z5;
            c0574b.fqh.setVisibility(8);
            sparseArray = (SparseArray) c0574b.rootView.getTag();
            if (sparseArray != null) {
            }
            sparseArray2.put(R.id.tag_subpb_main_floor_post_id, this.mPostId);
            if (!z4) {
            }
            sparseArray2.put(R.id.tag_forbid_user_post_id, postData.getId());
            sparseArray2.put(R.id.tag_clip_board, postData);
            if (!z6) {
            }
            if (!z7) {
            }
            if (this.iUn) {
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) c0574b.iUp.getLayoutParams();
                layoutParams3.topMargin = l.getDimens(this.mContext, R.dimen.ds32);
                layoutParams3.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
                c0574b.iUp.setLayoutParams(layoutParams3);
            }
            if (this.iUn) {
                LinearLayout.LayoutParams layoutParams22 = (LinearLayout.LayoutParams) c0574b.iUp.getLayoutParams();
                layoutParams22.topMargin = l.getDimens(this.mContext, R.dimen.ds8);
                layoutParams22.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
                c0574b.iUp.setLayoutParams(layoutParams22);
            }
            c0574b.fqh.setTag(sparseArray2);
            c0574b.iEW.setTag(sparseArray2);
            c0574b.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            c0574b.iEW.setOnLongClickListener(this.mOnLongClickListener);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(PostData postData, boolean z) {
        TbRichText cJz;
        SpannableStringBuilder aRG;
        TbRichTextData tbRichTextData;
        String str;
        String str2;
        SpannableStringBuilder aRG2;
        if (postData != null && (cJz = postData.cJz()) != null) {
            ArrayList<TbRichTextData> aRz = cJz.aRz();
            if (!v.isEmpty(aRz)) {
                if (z) {
                    TbRichTextData tbRichTextData2 = aRz.get(aRz.size() - 1);
                    int type = tbRichTextData2 != null ? tbRichTextData2.getType() : -1;
                    if (type == 1) {
                        String str3 = "   " + aq.getFormatTime(postData.getTime());
                        if (aRz.size() > 1) {
                            if ((aRz.get(aRz.size() + (-2)) != null ? aRz.get(aRz.size() - 2).getType() : -1) != type) {
                                str2 = aq.getFormatTime(postData.getTime());
                                aRG2 = tbRichTextData2.aRG();
                                if (cJz.hasAppendTime && aRG2 != 0 && cJz.appendLength <= aRG2.length()) {
                                    aRG2.delete(aRG2.length() - cJz.appendLength, aRG2.length());
                                }
                                String forceLToR = aq.forceLToR(str2);
                                if (aRG2 != null) {
                                    aRG2.append((CharSequence) forceLToR);
                                }
                                cJz.hasAppendTime = true;
                                cJz.appendLength = forceLToR.length();
                                tbRichTextData = tbRichTextData2;
                                str = forceLToR;
                            }
                        }
                        str2 = str3;
                        aRG2 = tbRichTextData2.aRG();
                        if (cJz.hasAppendTime) {
                            aRG2.delete(aRG2.length() - cJz.appendLength, aRG2.length());
                        }
                        String forceLToR2 = aq.forceLToR(str2);
                        if (aRG2 != null) {
                        }
                        cJz.hasAppendTime = true;
                        cJz.appendLength = forceLToR2.length();
                        tbRichTextData = tbRichTextData2;
                        str = forceLToR2;
                    } else if (cJz.hasAppendTime) {
                        tbRichTextData = tbRichTextData2;
                        str = "";
                    } else {
                        String formatTime = aq.getFormatTime(postData.getTime());
                        tbRichTextData = new TbRichTextData(1);
                        str = aq.forceLToR(formatTime);
                        tbRichTextData.j(str);
                        cJz.hasAppendTime = true;
                        cJz.appendLength = str.length();
                        aRz.add(tbRichTextData);
                    }
                    SpannableStringBuilder aRG3 = tbRichTextData.aRG();
                    if (aRG3 != null && str.length() <= aRG3.length()) {
                        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(TbConfig.getContentSizeOfLzl());
                        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(am.getColor(R.color.cp_cont_d));
                        aRG3.setSpan(absoluteSizeSpan, aRG3.length() - str.length(), aRG3.length(), 33);
                        aRG3.setSpan(foregroundColorSpan, aRG3.length() - str.length(), aRG3.length(), 33);
                        return;
                    }
                    return;
                }
                TbRichTextData tbRichTextData3 = aRz.get(aRz.size() - 1);
                if (cJz.hasAppendTime && tbRichTextData3 != null && (aRG = tbRichTextData3.aRG()) != null && cJz.appendLength <= aRG.length()) {
                    aRG.delete(aRG.length() - cJz.appendLength, aRG.length());
                }
                cJz.hasAppendTime = false;
                cJz.appendLength = 0;
            }
        }
    }

    public void Gc(String str) {
        this.mPostId = str;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void x(View.OnClickListener onClickListener) {
        this.ain = onClickListener;
    }
}
