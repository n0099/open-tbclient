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
    protected View.OnClickListener mcM = null;
    protected int mcN = 0;
    protected boolean mcO = false;
    protected boolean iBY = false;
    private boolean mIsFromCDN = true;
    private boolean mcP = false;
    private boolean fEd = false;
    private String mPostId = "";
    private int mSelectedPosition = -1;
    private View.OnLongClickListener mOnLongClickListener = null;
    private View.OnClickListener bdp = null;

    /* renamed from: com.baidu.tieba.pb.pb.sub.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C0854b {
        public TextView hXU;
        public TbRichTextView lMa;
        public int mSkinType = 3;
        public LinearLayout mcR;
        public View mcS;
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
        this.mcM = onClickListener;
    }

    public void ad(int i, boolean z) {
        this.mcN = i;
        this.mcO = z;
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
        C0854b c0854b;
        PostData postData = null;
        if (getItem(i) instanceof PostData) {
            postData = (PostData) getItem(i);
        }
        if (view == null) {
            if (postData.getType() == PostData.nrx) {
                view = duB();
            } else {
                view = createView();
            }
        }
        if ((view.getTag() instanceof a) && postData.getType() != PostData.nrx) {
            view = createView();
        }
        if ((view.getTag() instanceof SparseArray) && postData.getType() == PostData.nrx) {
            view = duB();
        }
        if ((view.getTag() instanceof SparseArray) && (c0854b = (C0854b) ((SparseArray) view.getTag()).get(R.id.tag_holder)) != null && postData != null) {
            boolean z = !this.iBY && i + 1 >= getCount();
            boolean z2 = i == this.mSelectedPosition;
            a(c0854b, postData, !z, i == 0, z2);
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
        public TextView mcQ;

        public a(Context context, View view) {
            this.mRootView = view;
            this.ghM = view.findViewById(R.id.divider_line);
            this.mcQ = (TextView) view.findViewById(R.id.center_reply_text);
            this.mcQ.setTextSize(0, TbConfig.getContentSizeOfLzl());
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }

        public void onChangeSkinType(int i) {
            if (i != this.mSkinType) {
                ao.setBackgroundColor(this.ghM, R.color.CAM_X0109);
                ao.setViewTextColor(this.mcQ, R.color.CAM_X0109);
                ao.setBackgroundColor(this.mcQ, R.color.CAM_X0201);
                this.mcQ.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ao.getDrawable(i, R.drawable.icon_floor_arrow_n), (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public View duB() {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.new_sub_pb_list_expand_view, (ViewGroup) null);
        inflate.setTag(new a(this.mContext, inflate));
        return inflate;
    }

    public View createView() {
        C0854b c0854b = new C0854b();
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.new_sub_pb_list_item, (ViewGroup) null);
        c0854b.rootView = inflate;
        c0854b.mcR = (LinearLayout) inflate.findViewById(R.id.sub_pb_item_columnlayout);
        if (this.mcP) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0854b.mcR.getLayoutParams();
            layoutParams.topMargin = l.getDimens(this.mContext, R.dimen.ds8);
            layoutParams.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
            c0854b.mcR.setLayoutParams(layoutParams);
        }
        c0854b.hXU = (TextView) inflate.findViewById(R.id.manage_btn);
        c0854b.lMa = (TbRichTextView) inflate.findViewById(R.id.new_sub_pb_list_richText);
        c0854b.mcS = inflate.findViewById(R.id.divide_bottom_view);
        c0854b.lMa.getLayoutStrategy().setSupportNoImage();
        if (!this.mcP) {
            c0854b.lMa.getLayoutStrategy().setLineSpacing(TbConfig.getContentLineSpaceOfLzl(), 1.0f);
            c0854b.lMa.getLayoutStrategy().tI(0);
            c0854b.lMa.getLayoutStrategy().tG(l.getDimens(this.mContext, R.dimen.tbds20));
            c0854b.lMa.getLayoutStrategy().tH(l.getDimens(this.mContext, R.dimen.tbds14));
            c0854b.lMa.setMaxLines(4);
            c0854b.lMa.setTextEllipsize(TextUtils.TruncateAt.END);
        }
        c0854b.lMa.setSubPbPost(true);
        c0854b.lMa.setTextColor(ao.getColor(R.color.CAM_X0106));
        c0854b.lMa.setTextSize(TbConfig.getContentSizeOfLzl());
        c0854b.lMa.setTextCenter(true);
        c0854b.lMa.setOnClickListener(this.bdp);
        c0854b.hXU.setOnClickListener(this.mcM);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(R.id.tag_holder, c0854b);
        inflate.setTag(sparseArray);
        return inflate;
    }

    public void a(C0854b c0854b, PostData postData, boolean z, boolean z2, boolean z3) {
        boolean z4;
        boolean z5;
        boolean z6;
        boolean z7;
        boolean z8;
        SparseArray sparseArray;
        if (c0854b != null && postData != null) {
            if (!postData.nsm && (this.mContext instanceof com.baidu.tieba.pb.pb.a)) {
                com.baidu.tieba.pb.pb.a aVar = (com.baidu.tieba.pb.pb.a) this.mContext;
                postData.a(aVar.getPageContext(), postData.brr() != null && aVar.PD(postData.brr().getUserId()));
            }
            if (z3) {
                ao.setBackgroundColor(c0854b.rootView, R.color.CAM_X0204);
            } else {
                c0854b.rootView.setBackgroundResource(0);
            }
            if (postData.dPf()) {
                c0854b.mcS.setVisibility(0);
            } else {
                c0854b.mcS.setVisibility(8);
            }
            c0854b.lMa.setPadding(0, 0, 0, 0);
            if (postData.brr() != null) {
                String name_show = postData.brr().getName_show();
                String userId = postData.brr().getUserId();
                SparseArray sparseArray2 = (SparseArray) c0854b.rootView.getTag();
                if (sparseArray2 == null) {
                    sparseArray2 = new SparseArray();
                    c0854b.rootView.setTag(sparseArray2);
                    c0854b.lMa.setTag(sparseArray2);
                }
                sparseArray2.put(R.id.tag_photo_username, name_show);
                sparseArray2.put(R.id.tag_photo_userid, userId);
                sparseArray2.put(R.id.tag_clip_board, postData);
                sparseArray2.put(R.id.tag_is_subpb, true);
            }
            c0854b.lMa.setLinkTextColor(ao.getColor(R.color.CAM_X0108));
            c0854b.lMa.setTextColor(ao.getColor(R.color.CAM_X0106));
            d(postData, this.mcP);
            TbRichText dPg = postData.dPg();
            if (dPg != null) {
                c0854b.lMa.setVoiceViewRes(R.layout.voice_play_btn_new);
                c0854b.lMa.setIsFromCDN(this.mIsFromCDN);
                if (c0854b.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                    dPg.isChanged = true;
                }
                c0854b.lMa.setText(dPg);
            }
            String userId2 = postData.brr().getUserId();
            if (this.mcN != 0) {
                boolean z9 = (this.mcN == 1002 || this.mcN == 3) ? false : true;
                boolean z10 = (this.mcN == 3 || this.alW.isBjh()) ? false : true;
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
            if (this.mcO) {
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
            c0854b.hXU.setVisibility(8);
            SparseArray sparseArray3 = (SparseArray) c0854b.rootView.getTag();
            if (sparseArray3 == null) {
                SparseArray sparseArray4 = new SparseArray();
                c0854b.rootView.setTag(sparseArray4);
                c0854b.lMa.setTag(sparseArray4);
                sparseArray = sparseArray4;
            } else {
                sparseArray = sparseArray3;
            }
            sparseArray.put(R.id.tag_subpb_main_floor_post_id, this.mPostId);
            if (z5) {
                sparseArray.put(R.id.tag_should_manage_visible, true);
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.mcN));
                if (postData.brr() != null) {
                    sparseArray.put(R.id.tag_forbid_user_name, postData.brr().getUserName());
                    sparseArray.put(R.id.tag_forbid_user_name_show, postData.brr().getName_show());
                    sparseArray.put(R.id.tag_forbid_user_portrait, postData.brr().getPortrait());
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
                    if (postData.brr() != null) {
                        sparseArray.put(R.id.tag_user_mute_mute_userid, postData.brr().getUserId());
                        sparseArray.put(R.id.tag_user_mute_mute_username, postData.brr().getUserName());
                        sparseArray.put(R.id.tag_user_mute_mute_nameshow, postData.brr().getName_show());
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
                sparseArray.put(R.id.tag_manage_user_identity, Integer.valueOf(this.mcN));
                sparseArray.put(R.id.tag_del_post_is_self, Boolean.valueOf(z7));
                sparseArray.put(R.id.tag_del_post_type, 2);
                sparseArray.put(R.id.tag_del_post_id, postData.getId());
            } else {
                sparseArray.put(R.id.tag_should_delete_visible, false);
            }
            if (this.mcP && z2 && this.fEd) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) c0854b.mcR.getLayoutParams();
                layoutParams.topMargin = l.getDimens(this.mContext, R.dimen.ds32);
                layoutParams.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
                c0854b.mcR.setLayoutParams(layoutParams);
            }
            if (this.mcP && !z2) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) c0854b.mcR.getLayoutParams();
                layoutParams2.topMargin = l.getDimens(this.mContext, R.dimen.ds8);
                layoutParams2.bottomMargin = l.getDimens(this.mContext, R.dimen.ds8);
                c0854b.mcR.setLayoutParams(layoutParams2);
            }
            c0854b.hXU.setTag(sparseArray);
            c0854b.lMa.setTag(sparseArray);
            c0854b.mSkinType = TbadkCoreApplication.getInst().getSkinType();
            c0854b.lMa.setOnLongClickListener(this.mOnLongClickListener);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void d(PostData postData, boolean z) {
        TbRichText dPg;
        SpannableStringBuilder bLe;
        TbRichTextData tbRichTextData;
        String str;
        SpannableStringBuilder bLe2;
        if (postData != null && (dPg = postData.dPg()) != null) {
            ArrayList<TbRichTextData> bKX = dPg.bKX();
            if (!x.isEmpty(bKX)) {
                if (z) {
                    TbRichTextData tbRichTextData2 = bKX.get(bKX.size() - 1);
                    int type = tbRichTextData2 != null ? tbRichTextData2.getType() : -1;
                    String str2 = "";
                    if (type == 1) {
                        String str3 = "   " + at.getFormatTime(postData.getTime());
                        if (bKX.size() > 1) {
                            if ((bKX.get(bKX.size() + (-2)) != null ? bKX.get(bKX.size() - 2).getType() : -1) != type) {
                                str = at.getFormatTime(postData.getTime());
                                bLe2 = tbRichTextData2.bLe();
                                if (dPg.hasAppendTime && bLe2 != 0 && dPg.appendLength <= bLe2.length()) {
                                    bLe2.delete(bLe2.length() - dPg.appendLength, bLe2.length());
                                }
                                str2 = at.forceLToR(str);
                                if (bLe2 != null) {
                                    bLe2.append((CharSequence) str2);
                                }
                                dPg.hasAppendTime = true;
                                dPg.appendLength = str2.length();
                                tbRichTextData = tbRichTextData2;
                            }
                        }
                        str = str3;
                        bLe2 = tbRichTextData2.bLe();
                        if (dPg.hasAppendTime) {
                            bLe2.delete(bLe2.length() - dPg.appendLength, bLe2.length());
                        }
                        str2 = at.forceLToR(str);
                        if (bLe2 != null) {
                        }
                        dPg.hasAppendTime = true;
                        dPg.appendLength = str2.length();
                        tbRichTextData = tbRichTextData2;
                    } else if (dPg.hasAppendTime) {
                        tbRichTextData = tbRichTextData2;
                    } else {
                        String formatTime = at.getFormatTime(postData.getTime());
                        tbRichTextData = new TbRichTextData(1);
                        String forceLToR = at.forceLToR(formatTime);
                        tbRichTextData.q(forceLToR);
                        dPg.hasAppendTime = true;
                        dPg.appendLength = forceLToR.length();
                        bKX.add(tbRichTextData);
                        str2 = forceLToR;
                    }
                    SpannableStringBuilder bLe3 = tbRichTextData.bLe();
                    if (bLe3 != null && str2.length() <= bLe3.length()) {
                        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(TbConfig.getContentSizeOfLzl());
                        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(ao.getColor(R.color.CAM_X0109));
                        bLe3.setSpan(absoluteSizeSpan, bLe3.length() - str2.length(), bLe3.length(), 33);
                        bLe3.setSpan(foregroundColorSpan, bLe3.length() - str2.length(), bLe3.length(), 33);
                        return;
                    }
                    return;
                }
                TbRichTextData tbRichTextData3 = bKX.get(bKX.size() - 1);
                if (dPg.hasAppendTime && tbRichTextData3 != null && (bLe = tbRichTextData3.bLe()) != null && dPg.appendLength <= bLe.length()) {
                    bLe.delete(bLe.length() - dPg.appendLength, bLe.length());
                }
                dPg.hasAppendTime = false;
                dPg.appendLength = 0;
            }
        }
    }

    public void Qn(String str) {
        this.mPostId = str;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.mOnLongClickListener = onLongClickListener;
    }

    public void C(View.OnClickListener onClickListener) {
        this.bdp = onClickListener;
    }
}
