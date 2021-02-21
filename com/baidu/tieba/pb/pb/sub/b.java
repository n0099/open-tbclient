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
import com.baidu.tbadk.core.data.cb;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class b extends BaseAdapter {
    private cb akU;
    protected Context mContext;
    protected View.OnClickListener mhz = null;
    protected int mhA = 0;
    protected boolean mhB = false;
    protected boolean iDp = false;
    private boolean mIsFromCDN = true;
    private boolean mhC = false;
    private boolean fBK = false;
    private String mPostId = "";
    private int mSelectedPosition = -1;
    private View.OnLongClickListener mOnLongClickListener = null;
    private View.OnClickListener bbI = null;

    /* renamed from: com.baidu.tieba.pb.pb.sub.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0841b {
        public TextView hXW;
        public TbRichTextView lQF;
        public int mSkinType = 3;
        public LinearLayout mhE;
        public View mhF;
        public View rootView;
    }

    public b(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void setThreadData(cb cbVar) {
        this.akU = cbVar;
    }

    public void Y(View.OnClickListener onClickListener) {
        this.mhz = onClickListener;
    }

    public void ad(int i, boolean z) {
        this.mhA = i;
        this.mhB = z;
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
        C0841b c0841b;
        PostData postData = null;
        if (getItem(i) instanceof PostData) {
            postData = (PostData) getItem(i);
        }
        if (view == null) {
            if (postData.getType() == PostData.nxb) {
                view = dte();
            } else {
                view = createView();
            }
        }
        if ((view.getTag() instanceof a) && postData.getType() != PostData.nxb) {
            view = createView();
        }
        if ((view.getTag() instanceof SparseArray) && postData.getType() == PostData.nxb) {
            view = dte();
        }
        if ((view.getTag() instanceof SparseArray) && (c0841b = (C0841b) ((SparseArray) view.getTag()).get(R.id.tag_holder)) != null && postData != null) {
            boolean z = !this.iDp && i + 1 >= getCount();
            boolean z2 = i == this.mSelectedPosition;
            a(c0841b, postData, !z, i == 0, z2);
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
        public View gfy;
        public View mRootView;
        private int mSkinType = 3;
        public TextView mhD;

        public a(Context context, View view) {
            this.mRootView = view;
            this.gfy = view.findViewById(R.id.divider_line);
            this.mhD = (TextView) view.findViewById(R.id.center_reply_text);
            this.mhD.setTextSize(0, TbConfig.getContentSizeOfLzl());
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }

        public void onChangeSkinType(int i) {
            if (i != this.mSkinType) {
                ap.setBackgroundColor(this.gfy, R.color.CAM_X0109);
                ap.setViewTextColor(this.mhD, R.color.CAM_X0109);
                ap.setBackgroundColor(this.mhD, R.color.CAM_X0201);
                this.mhD.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(i, R.drawable.icon_floor_arrow_n), (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public View dte() {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.new_sub_pb_list_expand_view, (ViewGroup) null);
        inflate.setTag(new a(this.mContext, inflate));
        return inflate;
    }

    public View createView() {
        C0841b c0841b = new C0841b();
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.new_sub_pb_list_item, (ViewGroup) null);
        c0841b.rootView = inflate;
        c0841b.mhE = (LinearLayout) inflate.findViewById(R.id.sub_pb_item_columnlayout);
        if (this.mhC) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0841b.mhE.getLayoutParams();
            layoutParams.topMargin = l.getDimens(this.mContext, R.dimen.ds8);
            layoutParams.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
            c0841b.mhE.setLayoutParams(layoutParams);
        }
        c0841b.hXW = (TextView) inflate.findViewById(R.id.manage_btn);
        c0841b.lQF = (TbRichTextView) inflate.findViewById(R.id.new_sub_pb_list_richText);
        c0841b.mhF = inflate.findViewById(R.id.divide_bottom_view);
        c0841b.lQF.getLayoutStrategy().setSupportNoImage();
        if (!this.mhC) {
            c0841b.lQF.getLayoutStrategy().setLineSpacing(TbConfig.getContentLineSpaceOfLzl(), 1.0f);
            c0841b.lQF.getLayoutStrategy().sh(0);
            c0841b.lQF.getLayoutStrategy().sf(l.getDimens(this.mContext, R.dimen.tbds20));
            c0841b.lQF.getLayoutStrategy().sg(l.getDimens(this.mContext, R.dimen.tbds14));
            c0841b.lQF.setMaxLines(4);
            c0841b.lQF.setTextEllipsize(TextUtils.TruncateAt.END);
        }
        c0841b.lQF.setSubPbPost(true);
        c0841b.lQF.setTextColor(ap.getColor(R.color.CAM_X0106));
        c0841b.lQF.setTextSize(TbConfig.getContentSizeOfLzl());
        c0841b.lQF.setTextCenter(true);
        c0841b.lQF.setOnClickListener(this.bbI);
        c0841b.hXW.setOnClickListener(this.mhz);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(R.id.tag_holder, c0841b);
        inflate.setTag(sparseArray);
        return inflate;
    }

    public void a(C0841b c0841b, PostData postData, boolean z, boolean z2, boolean z3) {
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        SparseArray sparseArray;
        if (c0841b != null && postData != null) {
            if (!postData.nxQ && (this.mContext instanceof com.baidu.tieba.pb.pb.a)) {
                com.baidu.tieba.pb.pb.a aVar = (com.baidu.tieba.pb.pb.a) this.mContext;
                postData.a(aVar.getPageContext(), postData.bnQ() != null && aVar.Po(postData.bnQ().getUserId()));
            }
            if (z3) {
                ap.setBackgroundColor(c0841b.rootView, R.color.CAM_X0204);
            } else {
                c0841b.rootView.setBackgroundResource(0);
            }
            if (postData.dNG()) {
                c0841b.mhF.setVisibility(0);
            } else {
                c0841b.mhF.setVisibility(8);
            }
            c0841b.lQF.setPadding(0, 0, 0, 0);
            if (postData.bnQ() != null) {
                String name_show = postData.bnQ().getName_show();
                String userId = postData.bnQ().getUserId();
                SparseArray sparseArray2 = (SparseArray) c0841b.rootView.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    c0841b.rootView.setTag(sparseArray2);
                    c0841b.lQF.setTag(sparseArray2);
                }
                sparseArray2.put(R.id.tag_photo_username, name_show);
                sparseArray2.put(R.id.tag_photo_userid, userId);
                sparseArray2.put(R.id.tag_clip_board, postData);
                sparseArray2.put(R.id.tag_is_subpb, true);
            }
            c0841b.lQF.setLinkTextColor(ap.getColor(R.color.CAM_X0108));
            c0841b.lQF.setTextColor(ap.getColor(R.color.CAM_X0106));
            d(postData, this.mhC);
            TbRichText dNH = postData.dNH();
            if (dNH != null) {
                c0841b.lQF.setVoiceViewRes(R.layout.voice_play_btn_new);
                c0841b.lQF.setIsFromCDN(this.mIsFromCDN);
                if (c0841b.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                    dNH.isChanged = true;
                }
                c0841b.lQF.setText(dNH);
            }
            String userId2 = postData.bnQ().getUserId();
            if (this.mhA != 0) {
                boolean z9 = (this.mhA == 1002 || this.mhA == 3) ? false : true;
                boolean z10 = (this.mhA == 3 || this.akU.isBjh()) ? false : true;
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
            if (this.mhB) {
                if (!this.akU.isBjh()) {
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
            c0841b.hXW.setVisibility(8);
            SparseArray sparseArray3 = (SparseArray) c0841b.rootView.getTag();
            if (sparseArray3 == null) {
                SparseArray sparseArray4 = new SparseArray();
                c0841b.rootView.setTag(sparseArray4);
                c0841b.lQF.setTag(sparseArray4);
                sparseArray = sparseArray4;
            } else {
                sparseArray = sparseArray3;
            }
            sparseArray.put(R.id.tag_subpb_main_floor_post_id, this.mPostId);
            if (z5) {
                sparseArray.put(R.id.tag_should_manage_visible, true);
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.mhA));
                if (postData.bnQ() != null) {
                    sparseArray.put(R.id.tag_forbid_user_name, postData.bnQ().getUserName());
                    sparseArray.put(R.id.tag_forbid_user_name_show, postData.bnQ().getName_show());
                    sparseArray.put(R.id.tag_forbid_user_portrait, postData.bnQ().getPortrait());
                }
                sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
            } else {
                sparseArray.put(R.id.tag_should_manage_visible, false);
            }
            sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
            sparseArray.put(R.id.tag_clip_board, postData);
            if (z6) {
                if (this.akU != null) {
                    sparseArray.put(R.id.tag_user_mute_visible, true);
                    sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (postData.bnQ() != null) {
                        sparseArray.put(R.id.tag_user_mute_mute_userid, postData.bnQ().getUserId());
                        sparseArray.put(R.id.tag_user_mute_mute_username, postData.bnQ().getUserName());
                        sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.bnQ().getName_show());
                    }
                    if (this.akU.getId() != null) {
                        sparseArray.put(R.id.tag_user_mute_thread_id, this.akU.getId());
                    }
                    sparseArray.put(R.id.tag_user_mute_post_id, postData.getId());
                }
            } else {
                sparseArray.put(R.id.tag_user_mute_visible, false);
            }
            if (z8) {
                sparseArray.put(R.id.tag_should_delete_visible, true);
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.mhA));
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z7));
                sparseArray.put(R.id.tag_del_post_type, 2);
                sparseArray.put(R.id.tag_del_post_id, postData.getId());
            } else {
                sparseArray.put(R.id.tag_should_delete_visible, false);
            }
            if (this.mhC && z2 && this.fBK) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0841b.mhE.getLayoutParams();
                layoutParams.topMargin = l.getDimens(this.mContext, R.dimen.ds32);
                layoutParams.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
                c0841b.mhE.setLayoutParams(layoutParams);
            }
            if (this.mhC && !z2) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) c0841b.mhE.getLayoutParams();
                layoutParams2.topMargin = l.getDimens(this.mContext, R.dimen.ds8);
                layoutParams2.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
                c0841b.mhE.setLayoutParams(layoutParams2);
            }
            c0841b.hXW.setTag(sparseArray);
            c0841b.lQF.setTag(sparseArray);
            c0841b.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            c0841b.lQF.setOnLongClickListener(this.mOnLongClickListener);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void d(PostData postData, boolean z) {
        TbRichText dNH;
        SpannableStringBuilder bHG;
        TbRichTextData tbRichTextData;
        String str;
        SpannableStringBuilder bHG2;
        if (postData != null && (dNH = postData.dNH()) != null) {
            ArrayList<TbRichTextData> bHz = dNH.bHz();
            if (!y.isEmpty(bHz)) {
                if (z) {
                    TbRichTextData tbRichTextData2 = bHz.get(bHz.size() - 1);
                    int type = tbRichTextData2 != null ? tbRichTextData2.getType() : -1;
                    String str2 = "";
                    if (type == 1) {
                        String str3 = "   " + au.getFormatTime(postData.getTime());
                        if (bHz.size() > 1) {
                            if ((bHz.get(bHz.size() + (-2)) != null ? bHz.get(bHz.size() - 2).getType() : -1) != type) {
                                str = au.getFormatTime(postData.getTime());
                                bHG2 = tbRichTextData2.bHG();
                                if (dNH.hasAppendTime && bHG2 != 0 && dNH.appendLength <= bHG2.length()) {
                                    bHG2.delete(bHG2.length() - dNH.appendLength, bHG2.length());
                                }
                                str2 = au.forceLToR(str);
                                if (bHG2 != null) {
                                    bHG2.append((CharSequence) str2);
                                }
                                dNH.hasAppendTime = true;
                                dNH.appendLength = str2.length();
                                tbRichTextData = tbRichTextData2;
                            }
                        }
                        str = str3;
                        bHG2 = tbRichTextData2.bHG();
                        if (dNH.hasAppendTime) {
                            bHG2.delete(bHG2.length() - dNH.appendLength, bHG2.length());
                        }
                        str2 = au.forceLToR(str);
                        if (bHG2 != null) {
                        }
                        dNH.hasAppendTime = true;
                        dNH.appendLength = str2.length();
                        tbRichTextData = tbRichTextData2;
                    } else if (dNH.hasAppendTime) {
                        tbRichTextData = tbRichTextData2;
                    } else {
                        String formatTime = au.getFormatTime(postData.getTime());
                        tbRichTextData = new TbRichTextData(1);
                        String forceLToR = au.forceLToR(formatTime);
                        tbRichTextData.p(forceLToR);
                        dNH.hasAppendTime = true;
                        dNH.appendLength = forceLToR.length();
                        bHz.add(tbRichTextData);
                        str2 = forceLToR;
                    }
                    SpannableStringBuilder bHG3 = tbRichTextData.bHG();
                    if (bHG3 != null && str2.length() <= bHG3.length()) {
                        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(TbConfig.getContentSizeOfLzl());
                        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(ap.getColor(R.color.CAM_X0109));
                        bHG3.setSpan(absoluteSizeSpan, bHG3.length() - str2.length(), bHG3.length(), 33);
                        bHG3.setSpan(foregroundColorSpan, bHG3.length() - str2.length(), bHG3.length(), 33);
                        return;
                    }
                    return;
                }
                TbRichTextData tbRichTextData3 = bHz.get(bHz.size() - 1);
                if (dNH.hasAppendTime && tbRichTextData3 != null && (bHG = tbRichTextData3.bHG()) != null && dNH.appendLength <= bHG.length()) {
                    bHG.delete(bHG.length() - dNH.appendLength, bHG.length());
                }
                dNH.hasAppendTime = false;
                dNH.appendLength = 0;
            }
        }
    }

    public void PY(String str) {
        this.mPostId = str;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void C(View.OnClickListener onClickListener) {
        this.bbI = onClickListener;
    }
}
