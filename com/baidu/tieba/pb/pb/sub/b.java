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
    private cb amn;
    protected Context mContext;
    protected View.OnClickListener mjD = null;
    protected int mjE = 0;
    protected boolean mjF = false;
    protected boolean iEY = false;
    private boolean mIsFromCDN = true;
    private boolean mjG = false;
    private boolean fDj = false;
    private String mPostId = "";
    private int mSelectedPosition = -1;
    private View.OnLongClickListener mOnLongClickListener = null;
    private View.OnClickListener bdi = null;

    /* renamed from: com.baidu.tieba.pb.pb.sub.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0847b {
        public TextView hZF;
        public TbRichTextView lSH;
        public int mSkinType = 3;
        public LinearLayout mjI;
        public View mjJ;
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
        this.amn = cbVar;
    }

    public void Z(View.OnClickListener onClickListener) {
        this.mjD = onClickListener;
    }

    public void ad(int i, boolean z) {
        this.mjE = i;
        this.mjF = z;
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
        C0847b c0847b;
        PostData postData = null;
        if (getItem(i) instanceof PostData) {
            postData = (PostData) getItem(i);
        }
        if (view == null) {
            if (postData.getType() == PostData.nzg) {
                view = dtn();
            } else {
                view = createView();
            }
        }
        if ((view.getTag() instanceof a) && postData.getType() != PostData.nzg) {
            view = createView();
        }
        if ((view.getTag() instanceof SparseArray) && postData.getType() == PostData.nzg) {
            view = dtn();
        }
        if ((view.getTag() instanceof SparseArray) && (c0847b = (C0847b) ((SparseArray) view.getTag()).get(R.id.tag_holder)) != null && postData != null) {
            boolean z = !this.iEY && i + 1 >= getCount();
            boolean z2 = i == this.mSelectedPosition;
            a(c0847b, postData, !z, i == 0, z2);
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
        public View ghb;
        public View mRootView;
        private int mSkinType = 3;
        public TextView mjH;

        public a(Context context, View view) {
            this.mRootView = view;
            this.ghb = view.findViewById(R.id.divider_line);
            this.mjH = (TextView) view.findViewById(R.id.center_reply_text);
            this.mjH.setTextSize(0, TbConfig.getContentSizeOfLzl());
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }

        public void onChangeSkinType(int i) {
            if (i != this.mSkinType) {
                ap.setBackgroundColor(this.ghb, R.color.CAM_X0109);
                ap.setViewTextColor(this.mjH, R.color.CAM_X0109);
                ap.setBackgroundColor(this.mjH, R.color.CAM_X0201);
                this.mjH.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(i, R.drawable.icon_floor_arrow_n), (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public View dtn() {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.new_sub_pb_list_expand_view, (ViewGroup) null);
        inflate.setTag(new a(this.mContext, inflate));
        return inflate;
    }

    public View createView() {
        C0847b c0847b = new C0847b();
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.new_sub_pb_list_item, (ViewGroup) null);
        c0847b.rootView = inflate;
        c0847b.mjI = (LinearLayout) inflate.findViewById(R.id.sub_pb_item_columnlayout);
        if (this.mjG) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0847b.mjI.getLayoutParams();
            layoutParams.topMargin = l.getDimens(this.mContext, R.dimen.ds8);
            layoutParams.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
            c0847b.mjI.setLayoutParams(layoutParams);
        }
        c0847b.hZF = (TextView) inflate.findViewById(R.id.manage_btn);
        c0847b.lSH = (TbRichTextView) inflate.findViewById(R.id.new_sub_pb_list_richText);
        c0847b.mjJ = inflate.findViewById(R.id.divide_bottom_view);
        c0847b.lSH.getLayoutStrategy().setSupportNoImage();
        if (!this.mjG) {
            c0847b.lSH.getLayoutStrategy().setLineSpacing(TbConfig.getContentLineSpaceOfLzl(), 1.0f);
            c0847b.lSH.getLayoutStrategy().sj(0);
            c0847b.lSH.getLayoutStrategy().sh(l.getDimens(this.mContext, R.dimen.tbds20));
            c0847b.lSH.getLayoutStrategy().si(l.getDimens(this.mContext, R.dimen.tbds14));
            c0847b.lSH.setMaxLines(4);
            c0847b.lSH.setTextEllipsize(TextUtils.TruncateAt.END);
        }
        c0847b.lSH.setSubPbPost(true);
        c0847b.lSH.setTextColor(ap.getColor(R.color.CAM_X0106));
        c0847b.lSH.setTextSize(TbConfig.getContentSizeOfLzl());
        c0847b.lSH.setTextCenter(true);
        c0847b.lSH.setOnClickListener(this.bdi);
        c0847b.hZF.setOnClickListener(this.mjD);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(R.id.tag_holder, c0847b);
        inflate.setTag(sparseArray);
        return inflate;
    }

    public void a(C0847b c0847b, PostData postData, boolean z, boolean z2, boolean z3) {
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        SparseArray sparseArray;
        if (c0847b != null && postData != null) {
            if (!postData.nzV && (this.mContext instanceof com.baidu.tieba.pb.pb.a)) {
                com.baidu.tieba.pb.pb.a aVar = (com.baidu.tieba.pb.pb.a) this.mContext;
                postData.a(aVar.getPageContext(), postData.bnS() != null && aVar.Pu(postData.bnS().getUserId()));
            }
            if (z3) {
                ap.setBackgroundColor(c0847b.rootView, R.color.CAM_X0204);
            } else {
                c0847b.rootView.setBackgroundResource(0);
            }
            if (postData.dNP()) {
                c0847b.mjJ.setVisibility(0);
            } else {
                c0847b.mjJ.setVisibility(8);
            }
            c0847b.lSH.setPadding(0, 0, 0, 0);
            if (postData.bnS() != null) {
                String name_show = postData.bnS().getName_show();
                String userId = postData.bnS().getUserId();
                SparseArray sparseArray2 = (SparseArray) c0847b.rootView.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    c0847b.rootView.setTag(sparseArray2);
                    c0847b.lSH.setTag(sparseArray2);
                }
                sparseArray2.put(R.id.tag_photo_username, name_show);
                sparseArray2.put(R.id.tag_photo_userid, userId);
                sparseArray2.put(R.id.tag_clip_board, postData);
                sparseArray2.put(R.id.tag_is_subpb, true);
            }
            c0847b.lSH.setLinkTextColor(ap.getColor(R.color.CAM_X0108));
            c0847b.lSH.setTextColor(ap.getColor(R.color.CAM_X0106));
            d(postData, this.mjG);
            TbRichText dNQ = postData.dNQ();
            if (dNQ != null) {
                c0847b.lSH.setVoiceViewRes(R.layout.voice_play_btn_new);
                c0847b.lSH.setIsFromCDN(this.mIsFromCDN);
                if (c0847b.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                    dNQ.isChanged = true;
                }
                c0847b.lSH.setText(dNQ);
            }
            String userId2 = postData.bnS().getUserId();
            if (this.mjE != 0) {
                boolean z9 = (this.mjE == 1002 || this.mjE == 3) ? false : true;
                boolean z10 = (this.mjE == 3 || this.amn.isBjh()) ? false : true;
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
            if (this.mjF) {
                if (!this.amn.isBjh()) {
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
            c0847b.hZF.setVisibility(8);
            SparseArray sparseArray3 = (SparseArray) c0847b.rootView.getTag();
            if (sparseArray3 == null) {
                SparseArray sparseArray4 = new SparseArray();
                c0847b.rootView.setTag(sparseArray4);
                c0847b.lSH.setTag(sparseArray4);
                sparseArray = sparseArray4;
            } else {
                sparseArray = sparseArray3;
            }
            sparseArray.put(R.id.tag_subpb_main_floor_post_id, this.mPostId);
            if (z5) {
                sparseArray.put(R.id.tag_should_manage_visible, true);
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.mjE));
                if (postData.bnS() != null) {
                    sparseArray.put(R.id.tag_forbid_user_name, postData.bnS().getUserName());
                    sparseArray.put(R.id.tag_forbid_user_name_show, postData.bnS().getName_show());
                    sparseArray.put(R.id.tag_forbid_user_portrait, postData.bnS().getPortrait());
                }
                sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
            } else {
                sparseArray.put(R.id.tag_should_manage_visible, false);
            }
            sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
            sparseArray.put(R.id.tag_clip_board, postData);
            if (z6) {
                if (this.amn != null) {
                    sparseArray.put(R.id.tag_user_mute_visible, true);
                    sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (postData.bnS() != null) {
                        sparseArray.put(R.id.tag_user_mute_mute_userid, postData.bnS().getUserId());
                        sparseArray.put(R.id.tag_user_mute_mute_username, postData.bnS().getUserName());
                        sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.bnS().getName_show());
                    }
                    if (this.amn.getId() != null) {
                        sparseArray.put(R.id.tag_user_mute_thread_id, this.amn.getId());
                    }
                    sparseArray.put(R.id.tag_user_mute_post_id, postData.getId());
                }
            } else {
                sparseArray.put(R.id.tag_user_mute_visible, false);
            }
            if (z8) {
                sparseArray.put(R.id.tag_should_delete_visible, true);
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.mjE));
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z7));
                sparseArray.put(R.id.tag_del_post_type, 2);
                sparseArray.put(R.id.tag_del_post_id, postData.getId());
            } else {
                sparseArray.put(R.id.tag_should_delete_visible, false);
            }
            if (this.mjG && z2 && this.fDj) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0847b.mjI.getLayoutParams();
                layoutParams.topMargin = l.getDimens(this.mContext, R.dimen.ds32);
                layoutParams.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
                c0847b.mjI.setLayoutParams(layoutParams);
            }
            if (this.mjG && !z2) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) c0847b.mjI.getLayoutParams();
                layoutParams2.topMargin = l.getDimens(this.mContext, R.dimen.ds8);
                layoutParams2.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
                c0847b.mjI.setLayoutParams(layoutParams2);
            }
            c0847b.hZF.setTag(sparseArray);
            c0847b.lSH.setTag(sparseArray);
            c0847b.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            c0847b.lSH.setOnLongClickListener(this.mOnLongClickListener);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void d(PostData postData, boolean z) {
        TbRichText dNQ;
        SpannableStringBuilder bHK;
        TbRichTextData tbRichTextData;
        String str;
        SpannableStringBuilder bHK2;
        if (postData != null && (dNQ = postData.dNQ()) != null) {
            ArrayList<TbRichTextData> bHD = dNQ.bHD();
            if (!y.isEmpty(bHD)) {
                if (z) {
                    TbRichTextData tbRichTextData2 = bHD.get(bHD.size() - 1);
                    int type = tbRichTextData2 != null ? tbRichTextData2.getType() : -1;
                    String str2 = "";
                    if (type == 1) {
                        String str3 = "   " + au.getFormatTime(postData.getTime());
                        if (bHD.size() > 1) {
                            if ((bHD.get(bHD.size() + (-2)) != null ? bHD.get(bHD.size() - 2).getType() : -1) != type) {
                                str = au.getFormatTime(postData.getTime());
                                bHK2 = tbRichTextData2.bHK();
                                if (dNQ.hasAppendTime && bHK2 != 0 && dNQ.appendLength <= bHK2.length()) {
                                    bHK2.delete(bHK2.length() - dNQ.appendLength, bHK2.length());
                                }
                                str2 = au.forceLToR(str);
                                if (bHK2 != null) {
                                    bHK2.append((CharSequence) str2);
                                }
                                dNQ.hasAppendTime = true;
                                dNQ.appendLength = str2.length();
                                tbRichTextData = tbRichTextData2;
                            }
                        }
                        str = str3;
                        bHK2 = tbRichTextData2.bHK();
                        if (dNQ.hasAppendTime) {
                            bHK2.delete(bHK2.length() - dNQ.appendLength, bHK2.length());
                        }
                        str2 = au.forceLToR(str);
                        if (bHK2 != null) {
                        }
                        dNQ.hasAppendTime = true;
                        dNQ.appendLength = str2.length();
                        tbRichTextData = tbRichTextData2;
                    } else if (dNQ.hasAppendTime) {
                        tbRichTextData = tbRichTextData2;
                    } else {
                        String formatTime = au.getFormatTime(postData.getTime());
                        tbRichTextData = new TbRichTextData(1);
                        String forceLToR = au.forceLToR(formatTime);
                        tbRichTextData.p(forceLToR);
                        dNQ.hasAppendTime = true;
                        dNQ.appendLength = forceLToR.length();
                        bHD.add(tbRichTextData);
                        str2 = forceLToR;
                    }
                    SpannableStringBuilder bHK3 = tbRichTextData.bHK();
                    if (bHK3 != null && str2.length() <= bHK3.length()) {
                        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(TbConfig.getContentSizeOfLzl());
                        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(ap.getColor(R.color.CAM_X0109));
                        bHK3.setSpan(absoluteSizeSpan, bHK3.length() - str2.length(), bHK3.length(), 33);
                        bHK3.setSpan(foregroundColorSpan, bHK3.length() - str2.length(), bHK3.length(), 33);
                        return;
                    }
                    return;
                }
                TbRichTextData tbRichTextData3 = bHD.get(bHD.size() - 1);
                if (dNQ.hasAppendTime && tbRichTextData3 != null && (bHK = tbRichTextData3.bHK()) != null && dNQ.appendLength <= bHK.length()) {
                    bHK.delete(bHK.length() - dNQ.appendLength, bHK.length());
                }
                dNQ.hasAppendTime = false;
                dNQ.appendLength = 0;
            }
        }
    }

    public void Qe(String str) {
        this.mPostId = str;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void C(View.OnClickListener onClickListener) {
        this.bdi = onClickListener;
    }
}
