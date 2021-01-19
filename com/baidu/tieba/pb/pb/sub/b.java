package com.baidu.tieba.pb.pb.sub;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
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
import com.baidu.tbadk.core.data.bz;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class b extends BaseAdapter {
    private bz ale;
    protected Context mContext;
    protected View.OnClickListener lYf = null;
    protected int lYg = 0;
    protected boolean lYh = false;
    protected boolean ixr = false;
    private boolean mIsFromCDN = true;
    private boolean lYi = false;
    private boolean fzv = false;
    private String mPostId = "";
    private int mSelectedPosition = -1;
    private View.OnLongClickListener mOnLongClickListener = null;
    private View.OnClickListener aYB = null;

    /* renamed from: com.baidu.tieba.pb.pb.sub.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0837b {
        public TextView hTn;
        public TbRichTextView lHw;
        public LinearLayout lYk;
        public View lYl;
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

    public void setThreadData(bz bzVar) {
        this.ale = bzVar;
    }

    public void Y(View.OnClickListener onClickListener) {
        this.lYf = onClickListener;
    }

    public void ad(int i, boolean z) {
        this.lYg = i;
        this.lYh = z;
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
        C0837b c0837b;
        PostData postData = null;
        if (getItem(i) instanceof PostData) {
            postData = (PostData) getItem(i);
        }
        if (view == null) {
            if (postData.getType() == PostData.nmR) {
                view = dqJ();
            } else {
                view = createView();
            }
        }
        if ((view.getTag() instanceof a) && postData.getType() != PostData.nmR) {
            view = createView();
        }
        if ((view.getTag() instanceof SparseArray) && postData.getType() == PostData.nmR) {
            view = dqJ();
        }
        if ((view.getTag() instanceof SparseArray) && (c0837b = (C0837b) ((SparseArray) view.getTag()).get(R.id.tag_holder)) != null && postData != null) {
            boolean z = !this.ixr && i + 1 >= getCount();
            boolean z2 = i == this.mSelectedPosition;
            a(c0837b, postData, !z, i == 0, z2);
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
        public View gde;
        public TextView lYj;
        public View mRootView;
        private int mSkinType = 3;

        public a(Context context, View view) {
            this.mRootView = view;
            this.gde = view.findViewById(R.id.divider_line);
            this.lYj = (TextView) view.findViewById(R.id.center_reply_text);
            this.lYj.setTextSize(0, TbConfig.getContentSizeOfLzl());
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }

        public void onChangeSkinType(int i) {
            if (i != this.mSkinType) {
                ao.setBackgroundColor(this.gde, R.color.CAM_X0109);
                ao.setViewTextColor(this.lYj, R.color.CAM_X0109);
                ao.setBackgroundColor(this.lYj, R.color.CAM_X0201);
                this.lYj.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ao.getDrawable(i, R.drawable.icon_floor_arrow_n), (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public View dqJ() {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.new_sub_pb_list_expand_view, (ViewGroup) null);
        inflate.setTag(new a(this.mContext, inflate));
        return inflate;
    }

    public View createView() {
        C0837b c0837b = new C0837b();
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.new_sub_pb_list_item, (ViewGroup) null);
        c0837b.rootView = inflate;
        c0837b.lYk = (LinearLayout) inflate.findViewById(R.id.sub_pb_item_columnlayout);
        if (this.lYi) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0837b.lYk.getLayoutParams();
            layoutParams.topMargin = l.getDimens(this.mContext, R.dimen.ds8);
            layoutParams.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
            c0837b.lYk.setLayoutParams(layoutParams);
        }
        c0837b.hTn = (TextView) inflate.findViewById(R.id.manage_btn);
        c0837b.lHw = (TbRichTextView) inflate.findViewById(R.id.new_sub_pb_list_richText);
        c0837b.lYl = inflate.findViewById(R.id.divide_bottom_view);
        c0837b.lHw.getLayoutStrategy().setSupportNoImage();
        if (!this.lYi) {
            c0837b.lHw.getLayoutStrategy().setLineSpacing(TbConfig.getContentLineSpaceOfLzl(), 1.0f);
            c0837b.lHw.getLayoutStrategy().sc(0);
            c0837b.lHw.getLayoutStrategy().sa(l.getDimens(this.mContext, R.dimen.tbds20));
            c0837b.lHw.getLayoutStrategy().sb(l.getDimens(this.mContext, R.dimen.tbds14));
            c0837b.lHw.setMaxLines(4);
            c0837b.lHw.setTextEllipsize(TextUtils.TruncateAt.END);
        }
        c0837b.lHw.setSubPbPost(true);
        c0837b.lHw.setTextColor(ao.getColor(R.color.CAM_X0106));
        c0837b.lHw.setTextSize(TbConfig.getContentSizeOfLzl());
        c0837b.lHw.setTextCenter(true);
        c0837b.lHw.setOnClickListener(this.aYB);
        c0837b.hTn.setOnClickListener(this.lYf);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(R.id.tag_holder, c0837b);
        inflate.setTag(sparseArray);
        return inflate;
    }

    public void a(C0837b c0837b, PostData postData, boolean z, boolean z2, boolean z3) {
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        SparseArray sparseArray;
        if (c0837b != null && postData != null) {
            if (!postData.nnG && (this.mContext instanceof com.baidu.tieba.pb.pb.a)) {
                com.baidu.tieba.pb.pb.a aVar = (com.baidu.tieba.pb.pb.a) this.mContext;
                postData.a(aVar.getPageContext(), postData.bnx() != null && aVar.Ow(postData.bnx().getUserId()));
            }
            if (z3) {
                ao.setBackgroundColor(c0837b.rootView, R.color.CAM_X0204);
            } else {
                c0837b.rootView.setBackgroundResource(0);
            }
            if (postData.dLn()) {
                c0837b.lYl.setVisibility(0);
            } else {
                c0837b.lYl.setVisibility(8);
            }
            c0837b.lHw.setPadding(0, 0, 0, 0);
            if (postData.bnx() != null) {
                String name_show = postData.bnx().getName_show();
                String userId = postData.bnx().getUserId();
                SparseArray sparseArray2 = (SparseArray) c0837b.rootView.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    c0837b.rootView.setTag(sparseArray2);
                    c0837b.lHw.setTag(sparseArray2);
                }
                sparseArray2.put(R.id.tag_photo_username, name_show);
                sparseArray2.put(R.id.tag_photo_userid, userId);
                sparseArray2.put(R.id.tag_clip_board, postData);
                sparseArray2.put(R.id.tag_is_subpb, true);
            }
            c0837b.lHw.setLinkTextColor(ao.getColor(R.color.CAM_X0108));
            c0837b.lHw.setTextColor(ao.getColor(R.color.CAM_X0106));
            d(postData, this.lYi);
            TbRichText dLo = postData.dLo();
            if (dLo != null) {
                c0837b.lHw.setVoiceViewRes(R.layout.voice_play_btn_new);
                c0837b.lHw.setIsFromCDN(this.mIsFromCDN);
                if (c0837b.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                    dLo.isChanged = true;
                }
                c0837b.lHw.setText(dLo);
            }
            String userId2 = postData.bnx().getUserId();
            if (this.lYg != 0) {
                boolean z9 = (this.lYg == 1002 || this.lYg == 3) ? false : true;
                boolean z10 = (this.lYg == 3 || this.ale.isBjh()) ? false : true;
                z5 = (userId2 == null || !userId2.equals(TbadkCoreApplication.getCurrentAccount())) ? z9 : false;
                if (userId2 == null || userId2.equals("0") || userId2.length() == 0) {
                    z4 = z10;
                    z5 = false;
                } else {
                    z4 = z10;
                }
            } else {
                z4 = false;
                z5 = false;
            }
            if (this.lYh) {
                if (!this.ale.isBjh()) {
                    z4 = true;
                }
                z6 = userId2 == null || !userId2.equals(TbadkCoreApplication.getCurrentAccount());
            } else {
                z6 = false;
            }
            if (userId2 == null || !userId2.equals(TbadkCoreApplication.getCurrentAccount())) {
                z7 = false;
                z8 = z4;
            } else {
                z7 = true;
                z8 = true;
            }
            c0837b.hTn.setVisibility(8);
            SparseArray sparseArray3 = (SparseArray) c0837b.rootView.getTag();
            if (sparseArray3 == null) {
                SparseArray sparseArray4 = new SparseArray();
                c0837b.rootView.setTag(sparseArray4);
                c0837b.lHw.setTag(sparseArray4);
                sparseArray = sparseArray4;
            } else {
                sparseArray = sparseArray3;
            }
            sparseArray.put(R.id.tag_subpb_main_floor_post_id, this.mPostId);
            if (z5) {
                sparseArray.put(R.id.tag_should_manage_visible, true);
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.lYg));
                if (postData.bnx() != null) {
                    sparseArray.put(R.id.tag_forbid_user_name, postData.bnx().getUserName());
                    sparseArray.put(R.id.tag_forbid_user_name_show, postData.bnx().getName_show());
                    sparseArray.put(R.id.tag_forbid_user_portrait, postData.bnx().getPortrait());
                }
                sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
            } else {
                sparseArray.put(R.id.tag_should_manage_visible, false);
            }
            sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
            sparseArray.put(R.id.tag_clip_board, postData);
            if (z6) {
                if (this.ale != null) {
                    sparseArray.put(R.id.tag_user_mute_visible, true);
                    sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (postData.bnx() != null) {
                        sparseArray.put(R.id.tag_user_mute_mute_userid, postData.bnx().getUserId());
                        sparseArray.put(R.id.tag_user_mute_mute_username, postData.bnx().getUserName());
                        sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.bnx().getName_show());
                    }
                    if (this.ale.getId() != null) {
                        sparseArray.put(R.id.tag_user_mute_thread_id, this.ale.getId());
                    }
                    sparseArray.put(R.id.tag_user_mute_post_id, postData.getId());
                }
            } else {
                sparseArray.put(R.id.tag_user_mute_visible, false);
            }
            if (z8) {
                sparseArray.put(R.id.tag_should_delete_visible, true);
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.lYg));
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z7));
                sparseArray.put(R.id.tag_del_post_type, 2);
                sparseArray.put(R.id.tag_del_post_id, postData.getId());
            } else {
                sparseArray.put(R.id.tag_should_delete_visible, false);
            }
            if (this.lYi && z2 && this.fzv) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0837b.lYk.getLayoutParams();
                layoutParams.topMargin = l.getDimens(this.mContext, R.dimen.ds32);
                layoutParams.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
                c0837b.lYk.setLayoutParams(layoutParams);
            }
            if (this.lYi && !z2) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) c0837b.lYk.getLayoutParams();
                layoutParams2.topMargin = l.getDimens(this.mContext, R.dimen.ds8);
                layoutParams2.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
                c0837b.lYk.setLayoutParams(layoutParams2);
            }
            c0837b.hTn.setTag(sparseArray);
            c0837b.lHw.setTag(sparseArray);
            c0837b.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            c0837b.lHw.setOnLongClickListener(this.mOnLongClickListener);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void d(PostData postData, boolean z) {
        TbRichText dLo;
        SpannableStringBuilder bHm;
        TbRichTextData tbRichTextData;
        String str;
        SpannableStringBuilder bHm2;
        if (postData != null && (dLo = postData.dLo()) != null) {
            ArrayList<TbRichTextData> bHf = dLo.bHf();
            if (!x.isEmpty(bHf)) {
                if (z) {
                    TbRichTextData tbRichTextData2 = bHf.get(bHf.size() - 1);
                    int type = tbRichTextData2 != null ? tbRichTextData2.getType() : -1;
                    String str2 = "";
                    if (type == 1) {
                        String str3 = "   " + at.getFormatTime(postData.getTime());
                        if (bHf.size() > 1) {
                            if ((bHf.get(bHf.size() + (-2)) != null ? bHf.get(bHf.size() - 2).getType() : -1) != type) {
                                str = at.getFormatTime(postData.getTime());
                                bHm2 = tbRichTextData2.bHm();
                                if (dLo.hasAppendTime && bHm2 != 0 && dLo.appendLength <= bHm2.length()) {
                                    bHm2.delete(bHm2.length() - dLo.appendLength, bHm2.length());
                                }
                                str2 = at.forceLToR(str);
                                if (bHm2 != null) {
                                    bHm2.append((CharSequence) str2);
                                }
                                dLo.hasAppendTime = true;
                                dLo.appendLength = str2.length();
                                tbRichTextData = tbRichTextData2;
                            }
                        }
                        str = str3;
                        bHm2 = tbRichTextData2.bHm();
                        if (dLo.hasAppendTime) {
                            bHm2.delete(bHm2.length() - dLo.appendLength, bHm2.length());
                        }
                        str2 = at.forceLToR(str);
                        if (bHm2 != null) {
                        }
                        dLo.hasAppendTime = true;
                        dLo.appendLength = str2.length();
                        tbRichTextData = tbRichTextData2;
                    } else if (dLo.hasAppendTime) {
                        tbRichTextData = tbRichTextData2;
                    } else {
                        String formatTime = at.getFormatTime(postData.getTime());
                        tbRichTextData = new TbRichTextData(1);
                        String forceLToR = at.forceLToR(formatTime);
                        tbRichTextData.q(forceLToR);
                        dLo.hasAppendTime = true;
                        dLo.appendLength = forceLToR.length();
                        bHf.add(tbRichTextData);
                        str2 = forceLToR;
                    }
                    SpannableStringBuilder bHm3 = tbRichTextData.bHm();
                    if (bHm3 != null && str2.length() <= bHm3.length()) {
                        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(TbConfig.getContentSizeOfLzl());
                        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(ao.getColor(R.color.CAM_X0109));
                        bHm3.setSpan(absoluteSizeSpan, bHm3.length() - str2.length(), bHm3.length(), 33);
                        bHm3.setSpan(foregroundColorSpan, bHm3.length() - str2.length(), bHm3.length(), 33);
                        return;
                    }
                    return;
                }
                TbRichTextData tbRichTextData3 = bHf.get(bHf.size() - 1);
                if (dLo.hasAppendTime && tbRichTextData3 != null && (bHm = tbRichTextData3.bHm()) != null && dLo.appendLength <= bHm.length()) {
                    bHm.delete(bHm.length() - dLo.appendLength, bHm.length());
                }
                dLo.hasAppendTime = false;
                dLo.appendLength = 0;
            }
        }
    }

    public void Pg(String str) {
        this.mPostId = str;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void C(View.OnClickListener onClickListener) {
        this.aYB = onClickListener;
    }
}
