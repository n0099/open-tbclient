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
import com.baidu.tbadk.core.data.bd;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class d extends BaseAdapter {
    private bd bkp;
    protected Context mContext;
    protected ArrayList<PostData> acx = null;
    protected View.OnClickListener fhp = null;
    protected int fhq = 0;
    protected boolean fhr = false;
    protected boolean fhs = false;
    protected boolean cjq = false;
    private boolean mIsFromCDN = true;
    private boolean fht = false;
    private boolean aCl = false;
    private String mPostId = "";
    private int mSelectedPosition = -1;

    public d(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void qo(int i) {
        this.mSelectedPosition = i;
    }

    public int qg(String str) {
        if (this.acx == null) {
            return -1;
        }
        int size = this.acx.size();
        for (int i = 0; i < size; i++) {
            if (this.acx.get(i).getId().equals(str)) {
                return i;
            }
        }
        return -1;
    }

    public void P(bd bdVar) {
        this.bkp = bdVar;
    }

    public void setDatas(ArrayList<PostData> arrayList) {
        if (arrayList == null) {
            this.acx = new ArrayList<>();
        } else {
            this.acx = arrayList;
        }
    }

    public void G(View.OnClickListener onClickListener) {
        this.fhp = onClickListener;
    }

    public void y(int i, boolean z) {
        this.fhq = i;
        this.fhr = z;
    }

    public void setHasMoreData(boolean z) {
        this.cjq = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.acx == null) {
            return 0;
        }
        return this.acx.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.acx == null || i < 0 || i >= this.acx.size()) {
            return null;
        }
        return this.acx.get(i);
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
            if (postData.getType() == PostData.gzk) {
                view = aXG();
            } else {
                view = kX();
            }
        }
        if ((view.getTag() instanceof a) && postData.getType() != PostData.gzk) {
            view = kX();
        }
        if ((view.getTag() instanceof SparseArray) && postData.getType() == PostData.gzk) {
            view = aXG();
        }
        if ((view.getTag() instanceof SparseArray) && (bVar = (b) ((SparseArray) view.getTag()).get(d.g.tag_holder)) != null && postData != null) {
            boolean z = !this.cjq && i + 1 >= getCount();
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

    /* loaded from: classes.dex */
    public class b {
        public TextView bOW;
        public TbRichTextView eQl;
        public LinearLayout fhw;
        public View fhx;
        public int mSkinType = 3;
        public View rootView;

        public b() {
        }
    }

    /* loaded from: classes.dex */
    public class a {
        public View bam;
        public TextView fhu;
        public View mRootView;
        private int mSkinType = 3;

        public a(Context context, View view) {
            this.mRootView = view;
            this.bam = view.findViewById(d.g.divider_line);
            this.fhu = (TextView) view.findViewById(d.g.center_reply_text);
            this.fhu.setTextSize(0, TbConfig.getContentSizeOfLzl());
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }

        public void onChangeSkinType(int i) {
            if (i != this.mSkinType) {
                aj.k(this.bam, d.C0082d.cp_cont_d);
                aj.i(this.fhu, d.C0082d.cp_cont_d);
                aj.k(this.fhu, d.C0082d.cp_bg_line_d);
                this.fhu.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.u(i, d.f.icon_floor_arrow_n), (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public View aXG() {
        View inflate = LayoutInflater.from(this.mContext).inflate(d.h.new_sub_pb_list_expand_view, (ViewGroup) null);
        inflate.setTag(new a(this.mContext, inflate));
        return inflate;
    }

    public View kX() {
        b bVar = new b();
        View inflate = LayoutInflater.from(this.mContext).inflate(d.h.new_sub_pb_list_item, (ViewGroup) null);
        bVar.rootView = inflate;
        bVar.fhw = (LinearLayout) inflate.findViewById(d.g.sub_pb_item_columnlayout);
        if (this.fht) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.fhw.getLayoutParams();
            layoutParams.topMargin = l.f(this.mContext, d.e.ds8);
            layoutParams.bottomMargin = l.f(this.mContext, d.e.ds8);
            bVar.fhw.setLayoutParams(layoutParams);
        }
        bVar.bOW = (TextView) inflate.findViewById(d.g.manage_btn);
        bVar.eQl = (TbRichTextView) inflate.findViewById(d.g.new_sub_pb_list_richText);
        bVar.fhx = inflate.findViewById(d.g.divide_bottom_view);
        bVar.eQl.getLayoutStrategy().Jp();
        if (!this.fht) {
            bVar.eQl.getLayoutStrategy().setLineSpacing(l.f(TbadkCoreApplication.getInst().getContext(), d.e.tbds12), 1.0f);
            bVar.eQl.getLayoutStrategy().ga(0);
            bVar.eQl.getLayoutStrategy().fY(l.f(this.mContext, d.e.tbds20));
            bVar.eQl.getLayoutStrategy().fZ(l.f(this.mContext, d.e.tbds3));
        }
        bVar.eQl.setSubPbPost(true);
        bVar.eQl.setTextColor(aj.getColor(d.C0082d.cp_cont_f));
        bVar.eQl.setTextSize(TbConfig.getContentSizeOfLzl());
        bVar.eQl.setTextCenter(true);
        bVar.bOW.setOnClickListener(this.fhp);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(d.g.tag_holder, bVar);
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
                aj.k(bVar.rootView, d.C0082d.cp_bg_line_b);
            } else {
                bVar.rootView.setBackgroundResource(0);
            }
            if (postData.bwp()) {
                bVar.fhx.setVisibility(0);
            } else {
                bVar.fhx.setVisibility(8);
            }
            bVar.eQl.setPadding(0, 0, 0, 0);
            if (postData.rx() != null) {
                String name_show = postData.rx().getName_show();
                String userId = postData.rx().getUserId();
                SparseArray sparseArray = (SparseArray) bVar.rootView.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    bVar.rootView.setTag(sparseArray);
                }
                sparseArray.put(d.g.tag_photo_username, name_show);
                sparseArray.put(d.g.tag_photo_userid, userId);
                sparseArray.put(d.g.tag_clip_board, postData);
                sparseArray.put(d.g.tag_is_subpb, true);
            }
            bVar.eQl.setLinkTextColor(aj.getColor(d.C0082d.cp_link_tip_c));
            bVar.eQl.setTextColor(aj.getColor(d.C0082d.cp_cont_f));
            a(postData, this.fht);
            TbRichText bwr = postData.bwr();
            if (bwr != null) {
                bVar.eQl.setVoiceViewRes(d.h.voice_play_btn_new);
                bVar.eQl.setIsFromCDN(this.mIsFromCDN);
                if (bVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                    bwr.isChanged = true;
                }
                bVar.eQl.setText(bwr);
            }
            String userId2 = postData.rx().getUserId();
            if (this.fhq != 0) {
                boolean z9 = this.fhq != 1002;
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
            if (!this.fhr) {
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
            bVar.bOW.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            bVar.bOW.setText("");
            bVar.bOW.setContentDescription("");
            aj.i(bVar.bOW, d.C0082d.cp_link_tip_c);
            if (z5) {
                bVar.bOW.setVisibility(0);
                bVar.bOW.setText(this.mContext.getString(d.j.manage));
                bVar.bOW.setContentDescription(this.mContext.getString(d.j.manage));
            } else if (z6) {
                bVar.bOW.setVisibility(0);
                bVar.bOW.setText(this.mContext.getString(d.j.mute));
                bVar.bOW.setContentDescription(this.mContext.getString(d.j.mute));
            } else if (z8) {
                bVar.bOW.setVisibility(0);
                if (this.fhq == 1002 && !z7) {
                    bVar.bOW.setText(this.mContext.getString(d.j.report_text));
                } else {
                    bVar.bOW.setText(this.mContext.getString(d.j.delete));
                }
            } else {
                bVar.bOW.setVisibility(8);
            }
            SparseArray sparseArray2 = (SparseArray) bVar.bOW.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                bVar.bOW.setTag(sparseArray2);
            }
            sparseArray2.put(d.g.tag_subpb_main_floor_post_id, this.mPostId);
            if (z5) {
                sparseArray2.put(d.g.tag_should_manage_visible, true);
                sparseArray2.put(d.g.tag_manage_user_identity, Integer.valueOf(this.fhq));
                sparseArray2.put(d.g.tag_forbid_user_name, postData.rx().getUserName());
                sparseArray2.put(d.g.tag_forbid_user_post_id, postData.getId());
            } else {
                sparseArray2.put(d.g.tag_should_manage_visible, false);
            }
            if (z6) {
                if (this.bkp != null) {
                    sparseArray2.put(d.g.tag_user_mute_visible, true);
                    sparseArray2.put(d.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (postData.rx() != null) {
                        sparseArray2.put(d.g.tag_user_mute_mute_userid, postData.rx().getUserId());
                        sparseArray2.put(d.g.tag_user_mute_mute_username, postData.rx().getUserName());
                    }
                    if (this.bkp.getId() != null) {
                        sparseArray2.put(d.g.tag_user_mute_thread_id, this.bkp.getId());
                    }
                    sparseArray2.put(d.g.tag_user_mute_post_id, postData.getId());
                }
            } else {
                sparseArray2.put(d.g.tag_user_mute_visible, false);
            }
            if (z8) {
                sparseArray2.put(d.g.tag_should_delete_visible, true);
                sparseArray2.put(d.g.tag_manage_user_identity, Integer.valueOf(this.fhq));
                sparseArray2.put(d.g.tag_del_post_is_self, Boolean.valueOf(z7));
                sparseArray2.put(d.g.tag_del_post_type, 2);
                sparseArray2.put(d.g.tag_del_post_id, postData.getId());
            } else {
                sparseArray2.put(d.g.tag_should_delete_visible, false);
            }
            if (this.fht && z2 && this.aCl) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.fhw.getLayoutParams();
                layoutParams.topMargin = l.f(this.mContext, d.e.ds32);
                layoutParams.bottomMargin = l.f(this.mContext, d.e.ds8);
                bVar.fhw.setLayoutParams(layoutParams);
            }
            if (this.fht && !z2) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.fhw.getLayoutParams();
                layoutParams2.topMargin = l.f(this.mContext, d.e.ds8);
                layoutParams2.bottomMargin = l.f(this.mContext, d.e.ds8);
                bVar.fhw.setLayoutParams(layoutParams2);
            }
            bVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(PostData postData, boolean z) {
        TbRichText bwr;
        SpannableStringBuilder Jx;
        TbRichTextData tbRichTextData;
        String str;
        String str2;
        SpannableStringBuilder Jx2;
        if (postData != null && (bwr = postData.bwr()) != null) {
            ArrayList<TbRichTextData> Jq = bwr.Jq();
            if (!v.w(Jq)) {
                if (z) {
                    TbRichTextData tbRichTextData2 = Jq.get(Jq.size() - 1);
                    int type = tbRichTextData2 != null ? tbRichTextData2.getType() : -1;
                    if (type == 1) {
                        String str3 = "   " + am.r(postData.getTime());
                        if (Jq.size() > 1) {
                            if ((Jq.get(Jq.size() + (-2)) != null ? Jq.get(Jq.size() - 2).getType() : -1) != type) {
                                str2 = am.r(postData.getTime());
                                Jx2 = tbRichTextData2.Jx();
                                if (bwr.hasAppendTime && Jx2 != 0 && bwr.appendLength <= Jx2.length()) {
                                    Jx2.delete(Jx2.length() - bwr.appendLength, Jx2.length());
                                }
                                String dT = am.dT(str2);
                                if (Jx2 != null) {
                                    Jx2.append((CharSequence) dT);
                                }
                                bwr.hasAppendTime = true;
                                bwr.appendLength = dT.length();
                                tbRichTextData = tbRichTextData2;
                                str = dT;
                            }
                        }
                        str2 = str3;
                        Jx2 = tbRichTextData2.Jx();
                        if (bwr.hasAppendTime) {
                            Jx2.delete(Jx2.length() - bwr.appendLength, Jx2.length());
                        }
                        String dT2 = am.dT(str2);
                        if (Jx2 != null) {
                        }
                        bwr.hasAppendTime = true;
                        bwr.appendLength = dT2.length();
                        tbRichTextData = tbRichTextData2;
                        str = dT2;
                    } else if (bwr.hasAppendTime) {
                        tbRichTextData = tbRichTextData2;
                        str = "";
                    } else {
                        String r = am.r(postData.getTime());
                        tbRichTextData = new TbRichTextData(1);
                        str = am.dT(r);
                        tbRichTextData.append(str);
                        bwr.hasAppendTime = true;
                        bwr.appendLength = str.length();
                        Jq.add(tbRichTextData);
                    }
                    SpannableStringBuilder Jx3 = tbRichTextData.Jx();
                    if (Jx3 != null && str.length() <= Jx3.length()) {
                        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(TbConfig.getContentSizeOfLzl());
                        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(aj.getColor(d.C0082d.cp_cont_d));
                        Jx3.setSpan(absoluteSizeSpan, Jx3.length() - str.length(), Jx3.length(), 33);
                        Jx3.setSpan(foregroundColorSpan, Jx3.length() - str.length(), Jx3.length(), 33);
                        return;
                    }
                    return;
                }
                TbRichTextData tbRichTextData3 = Jq.get(Jq.size() - 1);
                if (bwr.hasAppendTime && tbRichTextData3 != null && (Jx = tbRichTextData3.Jx()) != null && bwr.appendLength <= Jx.length()) {
                    Jx.delete(Jx.length() - bwr.appendLength, Jx.length());
                }
                bwr.hasAppendTime = false;
                bwr.appendLength = 0;
            }
        }
    }

    public void kn(boolean z) {
        this.fht = z;
    }

    public void ko(boolean z) {
        this.aCl = z;
    }

    public void qh(String str) {
        this.mPostId = str;
    }
}
