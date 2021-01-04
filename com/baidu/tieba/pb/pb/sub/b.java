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
    private bz alW;
    protected Context mContext;
    protected View.OnClickListener mcN = null;
    protected int mcO = 0;
    protected boolean mcP = false;
    protected boolean iBY = false;
    private boolean mIsFromCDN = true;
    private boolean mcQ = false;
    private boolean fEd = false;
    private String mPostId = "";
    private int mSelectedPosition = -1;
    private View.OnLongClickListener mOnLongClickListener = null;
    private View.OnClickListener bdp = null;

    /* renamed from: com.baidu.tieba.pb.pb.sub.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0821b {
        public TextView hXU;
        public TbRichTextView lMb;
        public int mSkinType = 3;
        public LinearLayout mcS;
        public View mcT;
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
        this.alW = bzVar;
    }

    public void Y(View.OnClickListener onClickListener) {
        this.mcN = onClickListener;
    }

    public void ad(int i, boolean z) {
        this.mcO = i;
        this.mcP = z;
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
        C0821b c0821b;
        PostData postData = null;
        if (getItem(i) instanceof PostData) {
            postData = (PostData) getItem(i);
        }
        if (view == null) {
            if (postData.getType() == PostData.nry) {
                view = duA();
            } else {
                view = createView();
            }
        }
        if ((view.getTag() instanceof a) && postData.getType() != PostData.nry) {
            view = createView();
        }
        if ((view.getTag() instanceof SparseArray) && postData.getType() == PostData.nry) {
            view = duA();
        }
        if ((view.getTag() instanceof SparseArray) && (c0821b = (C0821b) ((SparseArray) view.getTag()).get(R.id.tag_holder)) != null && postData != null) {
            boolean z = !this.iBY && i + 1 >= getCount();
            boolean z2 = i == this.mSelectedPosition;
            a(c0821b, postData, !z, i == 0, z2);
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
        public View ghM;
        public View mRootView;
        private int mSkinType = 3;
        public TextView mcR;

        public a(Context context, View view) {
            this.mRootView = view;
            this.ghM = view.findViewById(R.id.divider_line);
            this.mcR = (TextView) view.findViewById(R.id.center_reply_text);
            this.mcR.setTextSize(0, TbConfig.getContentSizeOfLzl());
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }

        public void onChangeSkinType(int i) {
            if (i != this.mSkinType) {
                ao.setBackgroundColor(this.ghM, R.color.CAM_X0109);
                ao.setViewTextColor(this.mcR, R.color.CAM_X0109);
                ao.setBackgroundColor(this.mcR, R.color.CAM_X0201);
                this.mcR.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ao.getDrawable(i, R.drawable.icon_floor_arrow_n), (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public View duA() {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.new_sub_pb_list_expand_view, (ViewGroup) null);
        inflate.setTag(new a(this.mContext, inflate));
        return inflate;
    }

    public View createView() {
        C0821b c0821b = new C0821b();
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.new_sub_pb_list_item, (ViewGroup) null);
        c0821b.rootView = inflate;
        c0821b.mcS = (LinearLayout) inflate.findViewById(R.id.sub_pb_item_columnlayout);
        if (this.mcQ) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0821b.mcS.getLayoutParams();
            layoutParams.topMargin = l.getDimens(this.mContext, R.dimen.ds8);
            layoutParams.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
            c0821b.mcS.setLayoutParams(layoutParams);
        }
        c0821b.hXU = (TextView) inflate.findViewById(R.id.manage_btn);
        c0821b.lMb = (TbRichTextView) inflate.findViewById(R.id.new_sub_pb_list_richText);
        c0821b.mcT = inflate.findViewById(R.id.divide_bottom_view);
        c0821b.lMb.getLayoutStrategy().setSupportNoImage();
        if (!this.mcQ) {
            c0821b.lMb.getLayoutStrategy().setLineSpacing(TbConfig.getContentLineSpaceOfLzl(), 1.0f);
            c0821b.lMb.getLayoutStrategy().tI(0);
            c0821b.lMb.getLayoutStrategy().tG(l.getDimens(this.mContext, R.dimen.tbds20));
            c0821b.lMb.getLayoutStrategy().tH(l.getDimens(this.mContext, R.dimen.tbds14));
            c0821b.lMb.setMaxLines(4);
            c0821b.lMb.setTextEllipsize(TextUtils.TruncateAt.END);
        }
        c0821b.lMb.setSubPbPost(true);
        c0821b.lMb.setTextColor(ao.getColor(R.color.CAM_X0106));
        c0821b.lMb.setTextSize(TbConfig.getContentSizeOfLzl());
        c0821b.lMb.setTextCenter(true);
        c0821b.lMb.setOnClickListener(this.bdp);
        c0821b.hXU.setOnClickListener(this.mcN);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(R.id.tag_holder, c0821b);
        inflate.setTag(sparseArray);
        return inflate;
    }

    public void a(C0821b c0821b, PostData postData, boolean z, boolean z2, boolean z3) {
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        SparseArray sparseArray;
        if (c0821b != null && postData != null) {
            if (!postData.nsn && (this.mContext instanceof com.baidu.tieba.pb.pb.a)) {
                com.baidu.tieba.pb.pb.a aVar = (com.baidu.tieba.pb.pb.a) this.mContext;
                postData.a(aVar.getPageContext(), postData.brq() != null && aVar.PE(postData.brq().getUserId()));
            }
            if (z3) {
                ao.setBackgroundColor(c0821b.rootView, R.color.CAM_X0204);
            } else {
                c0821b.rootView.setBackgroundResource(0);
            }
            if (postData.dPe()) {
                c0821b.mcT.setVisibility(0);
            } else {
                c0821b.mcT.setVisibility(8);
            }
            c0821b.lMb.setPadding(0, 0, 0, 0);
            if (postData.brq() != null) {
                String name_show = postData.brq().getName_show();
                String userId = postData.brq().getUserId();
                SparseArray sparseArray2 = (SparseArray) c0821b.rootView.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    c0821b.rootView.setTag(sparseArray2);
                    c0821b.lMb.setTag(sparseArray2);
                }
                sparseArray2.put(R.id.tag_photo_username, name_show);
                sparseArray2.put(R.id.tag_photo_userid, userId);
                sparseArray2.put(R.id.tag_clip_board, postData);
                sparseArray2.put(R.id.tag_is_subpb, true);
            }
            c0821b.lMb.setLinkTextColor(ao.getColor(R.color.CAM_X0108));
            c0821b.lMb.setTextColor(ao.getColor(R.color.CAM_X0106));
            d(postData, this.mcQ);
            TbRichText dPf = postData.dPf();
            if (dPf != null) {
                c0821b.lMb.setVoiceViewRes(R.layout.voice_play_btn_new);
                c0821b.lMb.setIsFromCDN(this.mIsFromCDN);
                if (c0821b.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                    dPf.isChanged = true;
                }
                c0821b.lMb.setText(dPf);
            }
            String userId2 = postData.brq().getUserId();
            if (this.mcO != 0) {
                boolean z9 = (this.mcO == 1002 || this.mcO == 3) ? false : true;
                boolean z10 = (this.mcO == 3 || this.alW.isBjh()) ? false : true;
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
            if (this.mcP) {
                if (!this.alW.isBjh()) {
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
            c0821b.hXU.setVisibility(8);
            SparseArray sparseArray3 = (SparseArray) c0821b.rootView.getTag();
            if (sparseArray3 == null) {
                SparseArray sparseArray4 = new SparseArray();
                c0821b.rootView.setTag(sparseArray4);
                c0821b.lMb.setTag(sparseArray4);
                sparseArray = sparseArray4;
            } else {
                sparseArray = sparseArray3;
            }
            sparseArray.put(R.id.tag_subpb_main_floor_post_id, this.mPostId);
            if (z5) {
                sparseArray.put(R.id.tag_should_manage_visible, true);
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.mcO));
                if (postData.brq() != null) {
                    sparseArray.put(R.id.tag_forbid_user_name, postData.brq().getUserName());
                    sparseArray.put(R.id.tag_forbid_user_name_show, postData.brq().getName_show());
                    sparseArray.put(R.id.tag_forbid_user_portrait, postData.brq().getPortrait());
                }
                sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
            } else {
                sparseArray.put(R.id.tag_should_manage_visible, false);
            }
            sparseArray.put(R.id.tag_forbid_user_post_id, postData.getId());
            sparseArray.put(R.id.tag_clip_board, postData);
            if (z6) {
                if (this.alW != null) {
                    sparseArray.put(R.id.tag_user_mute_visible, true);
                    sparseArray.put(R.id.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (postData.brq() != null) {
                        sparseArray.put(R.id.tag_user_mute_mute_userid, postData.brq().getUserId());
                        sparseArray.put(R.id.tag_user_mute_mute_username, postData.brq().getUserName());
                        sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.brq().getName_show());
                    }
                    if (this.alW.getId() != null) {
                        sparseArray.put(R.id.tag_user_mute_thread_id, this.alW.getId());
                    }
                    sparseArray.put(R.id.tag_user_mute_post_id, postData.getId());
                }
            } else {
                sparseArray.put(R.id.tag_user_mute_visible, false);
            }
            if (z8) {
                sparseArray.put(R.id.tag_should_delete_visible, true);
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.mcO));
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z7));
                sparseArray.put(R.id.tag_del_post_type, 2);
                sparseArray.put(R.id.tag_del_post_id, postData.getId());
            } else {
                sparseArray.put(R.id.tag_should_delete_visible, false);
            }
            if (this.mcQ && z2 && this.fEd) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0821b.mcS.getLayoutParams();
                layoutParams.topMargin = l.getDimens(this.mContext, R.dimen.ds32);
                layoutParams.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
                c0821b.mcS.setLayoutParams(layoutParams);
            }
            if (this.mcQ && !z2) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) c0821b.mcS.getLayoutParams();
                layoutParams2.topMargin = l.getDimens(this.mContext, R.dimen.ds8);
                layoutParams2.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
                c0821b.mcS.setLayoutParams(layoutParams2);
            }
            c0821b.hXU.setTag(sparseArray);
            c0821b.lMb.setTag(sparseArray);
            c0821b.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            c0821b.lMb.setOnLongClickListener(this.mOnLongClickListener);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void d(PostData postData, boolean z) {
        TbRichText dPf;
        SpannableStringBuilder bLd;
        TbRichTextData tbRichTextData;
        String str;
        SpannableStringBuilder bLd2;
        if (postData != null && (dPf = postData.dPf()) != null) {
            ArrayList<TbRichTextData> bKW = dPf.bKW();
            if (!x.isEmpty(bKW)) {
                if (z) {
                    TbRichTextData tbRichTextData2 = bKW.get(bKW.size() - 1);
                    int type = tbRichTextData2 != null ? tbRichTextData2.getType() : -1;
                    String str2 = "";
                    if (type == 1) {
                        String str3 = "   " + at.getFormatTime(postData.getTime());
                        if (bKW.size() > 1) {
                            if ((bKW.get(bKW.size() + (-2)) != null ? bKW.get(bKW.size() - 2).getType() : -1) != type) {
                                str = at.getFormatTime(postData.getTime());
                                bLd2 = tbRichTextData2.bLd();
                                if (dPf.hasAppendTime && bLd2 != 0 && dPf.appendLength <= bLd2.length()) {
                                    bLd2.delete(bLd2.length() - dPf.appendLength, bLd2.length());
                                }
                                str2 = at.forceLToR(str);
                                if (bLd2 != null) {
                                    bLd2.append((CharSequence) str2);
                                }
                                dPf.hasAppendTime = true;
                                dPf.appendLength = str2.length();
                                tbRichTextData = tbRichTextData2;
                            }
                        }
                        str = str3;
                        bLd2 = tbRichTextData2.bLd();
                        if (dPf.hasAppendTime) {
                            bLd2.delete(bLd2.length() - dPf.appendLength, bLd2.length());
                        }
                        str2 = at.forceLToR(str);
                        if (bLd2 != null) {
                        }
                        dPf.hasAppendTime = true;
                        dPf.appendLength = str2.length();
                        tbRichTextData = tbRichTextData2;
                    } else if (dPf.hasAppendTime) {
                        tbRichTextData = tbRichTextData2;
                    } else {
                        String formatTime = at.getFormatTime(postData.getTime());
                        tbRichTextData = new TbRichTextData(1);
                        String forceLToR = at.forceLToR(formatTime);
                        tbRichTextData.q(forceLToR);
                        dPf.hasAppendTime = true;
                        dPf.appendLength = forceLToR.length();
                        bKW.add(tbRichTextData);
                        str2 = forceLToR;
                    }
                    SpannableStringBuilder bLd3 = tbRichTextData.bLd();
                    if (bLd3 != null && str2.length() <= bLd3.length()) {
                        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(TbConfig.getContentSizeOfLzl());
                        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(ao.getColor(R.color.CAM_X0109));
                        bLd3.setSpan(absoluteSizeSpan, bLd3.length() - str2.length(), bLd3.length(), 33);
                        bLd3.setSpan(foregroundColorSpan, bLd3.length() - str2.length(), bLd3.length(), 33);
                        return;
                    }
                    return;
                }
                TbRichTextData tbRichTextData3 = bKW.get(bKW.size() - 1);
                if (dPf.hasAppendTime && tbRichTextData3 != null && (bLd = tbRichTextData3.bLd()) != null && dPf.appendLength <= bLd.length()) {
                    bLd.delete(bLd.length() - dPf.appendLength, bLd.length());
                }
                dPf.hasAppendTime = false;
                dPf.appendLength = 0;
            }
        }
    }

    public void Qo(String str) {
        this.mPostId = str;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void C(View.OnClickListener onClickListener) {
        this.bdp = onClickListener;
    }
}
