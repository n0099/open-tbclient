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
    private bd bkq;
    protected Context mContext;
    protected ArrayList<PostData> acr = null;
    protected View.OnClickListener fio = null;
    protected int fip = 0;
    protected boolean fiq = false;
    protected boolean fir = false;
    protected boolean cjE = false;
    private boolean mIsFromCDN = true;
    private boolean fis = false;
    private boolean aCq = false;
    private String mPostId = "";
    private int mSelectedPosition = -1;

    public d(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void qv(int i) {
        this.mSelectedPosition = i;
    }

    public int qg(String str) {
        if (this.acr == null) {
            return -1;
        }
        int size = this.acr.size();
        for (int i = 0; i < size; i++) {
            if (this.acr.get(i).getId().equals(str)) {
                return i;
            }
        }
        return -1;
    }

    public void R(bd bdVar) {
        this.bkq = bdVar;
    }

    public void setDatas(ArrayList<PostData> arrayList) {
        if (arrayList == null) {
            this.acr = new ArrayList<>();
        } else {
            this.acr = arrayList;
        }
    }

    public void G(View.OnClickListener onClickListener) {
        this.fio = onClickListener;
    }

    public void y(int i, boolean z) {
        this.fip = i;
        this.fiq = z;
    }

    public void setHasMoreData(boolean z) {
        this.cjE = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.acr == null) {
            return 0;
        }
        return this.acr.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.acr == null || i < 0 || i >= this.acr.size()) {
            return null;
        }
        return this.acr.get(i);
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
            if (postData.getType() == PostData.gBT) {
                view = aXO();
            } else {
                view = kX();
            }
        }
        if ((view.getTag() instanceof a) && postData.getType() != PostData.gBT) {
            view = kX();
        }
        if ((view.getTag() instanceof SparseArray) && postData.getType() == PostData.gBT) {
            view = aXO();
        }
        if ((view.getTag() instanceof SparseArray) && (bVar = (b) ((SparseArray) view.getTag()).get(d.g.tag_holder)) != null && postData != null) {
            boolean z = !this.cjE && i + 1 >= getCount();
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
        public TextView bPa;
        public TbRichTextView eRo;
        public LinearLayout fiv;
        public View fiw;
        public int mSkinType = 3;
        public View rootView;

        public b() {
        }
    }

    /* loaded from: classes.dex */
    public class a {
        public View ban;
        public TextView fit;
        public View mRootView;
        private int mSkinType = 3;

        public a(Context context, View view) {
            this.mRootView = view;
            this.ban = view.findViewById(d.g.divider_line);
            this.fit = (TextView) view.findViewById(d.g.center_reply_text);
            this.fit.setTextSize(0, TbConfig.getContentSizeOfLzl());
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }

        public void onChangeSkinType(int i) {
            if (i != this.mSkinType) {
                aj.k(this.ban, d.C0096d.cp_cont_d);
                aj.i(this.fit, d.C0096d.cp_cont_d);
                aj.k(this.fit, d.C0096d.cp_bg_line_d);
                this.fit.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.v(i, d.f.icon_floor_arrow_n), (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public View aXO() {
        View inflate = LayoutInflater.from(this.mContext).inflate(d.h.new_sub_pb_list_expand_view, (ViewGroup) null);
        inflate.setTag(new a(this.mContext, inflate));
        return inflate;
    }

    public View kX() {
        b bVar = new b();
        View inflate = LayoutInflater.from(this.mContext).inflate(d.h.new_sub_pb_list_item, (ViewGroup) null);
        bVar.rootView = inflate;
        bVar.fiv = (LinearLayout) inflate.findViewById(d.g.sub_pb_item_columnlayout);
        if (this.fis) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.fiv.getLayoutParams();
            layoutParams.topMargin = l.f(this.mContext, d.e.ds8);
            layoutParams.bottomMargin = l.f(this.mContext, d.e.ds8);
            bVar.fiv.setLayoutParams(layoutParams);
        }
        bVar.bPa = (TextView) inflate.findViewById(d.g.manage_btn);
        bVar.eRo = (TbRichTextView) inflate.findViewById(d.g.new_sub_pb_list_richText);
        bVar.fiw = inflate.findViewById(d.g.divide_bottom_view);
        bVar.eRo.getLayoutStrategy().Jq();
        if (!this.fis) {
            bVar.eRo.getLayoutStrategy().setLineSpacing(l.f(TbadkCoreApplication.getInst().getContext(), d.e.tbds12), 1.0f);
            bVar.eRo.getLayoutStrategy().ga(0);
            bVar.eRo.getLayoutStrategy().fY(l.f(this.mContext, d.e.tbds20));
            bVar.eRo.getLayoutStrategy().fZ(l.f(this.mContext, d.e.tbds3));
        }
        bVar.eRo.setSubPbPost(true);
        bVar.eRo.setTextColor(aj.getColor(d.C0096d.cp_cont_f));
        bVar.eRo.setTextSize(TbConfig.getContentSizeOfLzl());
        bVar.eRo.setTextCenter(true);
        bVar.bPa.setOnClickListener(this.fio);
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
                aj.k(bVar.rootView, d.C0096d.cp_bg_line_b);
            } else {
                bVar.rootView.setBackgroundResource(0);
            }
            if (postData.bwW()) {
                bVar.fiw.setVisibility(0);
            } else {
                bVar.fiw.setVisibility(8);
            }
            bVar.eRo.setPadding(0, 0, 0, 0);
            if (postData.rv() != null) {
                String name_show = postData.rv().getName_show();
                String userId = postData.rv().getUserId();
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
            bVar.eRo.setLinkTextColor(aj.getColor(d.C0096d.cp_link_tip_c));
            bVar.eRo.setTextColor(aj.getColor(d.C0096d.cp_cont_f));
            a(postData, this.fis);
            TbRichText bwY = postData.bwY();
            if (bwY != null) {
                bVar.eRo.setVoiceViewRes(d.h.voice_play_btn_new);
                bVar.eRo.setIsFromCDN(this.mIsFromCDN);
                if (bVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                    bwY.isChanged = true;
                }
                bVar.eRo.setText(bwY);
            }
            String userId2 = postData.rv().getUserId();
            if (this.fip != 0) {
                boolean z9 = this.fip != 1002;
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
            if (!this.fiq) {
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
            bVar.bPa.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            bVar.bPa.setText("");
            bVar.bPa.setContentDescription("");
            aj.i(bVar.bPa, d.C0096d.cp_link_tip_c);
            if (z5) {
                bVar.bPa.setVisibility(0);
                bVar.bPa.setText(this.mContext.getString(d.j.manage));
                bVar.bPa.setContentDescription(this.mContext.getString(d.j.manage));
            } else if (z6) {
                bVar.bPa.setVisibility(0);
                bVar.bPa.setText(this.mContext.getString(d.j.mute));
                bVar.bPa.setContentDescription(this.mContext.getString(d.j.mute));
            } else if (z8) {
                bVar.bPa.setVisibility(0);
                if (this.fip == 1002 && !z7) {
                    bVar.bPa.setText(this.mContext.getString(d.j.report_text));
                } else {
                    bVar.bPa.setText(this.mContext.getString(d.j.delete));
                }
            } else {
                bVar.bPa.setVisibility(8);
            }
            SparseArray sparseArray2 = (SparseArray) bVar.bPa.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                bVar.bPa.setTag(sparseArray2);
            }
            sparseArray2.put(d.g.tag_subpb_main_floor_post_id, this.mPostId);
            if (z5) {
                sparseArray2.put(d.g.tag_should_manage_visible, true);
                sparseArray2.put(d.g.tag_manage_user_identity, Integer.valueOf(this.fip));
                sparseArray2.put(d.g.tag_forbid_user_name, postData.rv().getUserName());
                sparseArray2.put(d.g.tag_forbid_user_post_id, postData.getId());
            } else {
                sparseArray2.put(d.g.tag_should_manage_visible, false);
            }
            if (z6) {
                if (this.bkq != null) {
                    sparseArray2.put(d.g.tag_user_mute_visible, true);
                    sparseArray2.put(d.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (postData.rv() != null) {
                        sparseArray2.put(d.g.tag_user_mute_mute_userid, postData.rv().getUserId());
                        sparseArray2.put(d.g.tag_user_mute_mute_username, postData.rv().getUserName());
                    }
                    if (this.bkq.getId() != null) {
                        sparseArray2.put(d.g.tag_user_mute_thread_id, this.bkq.getId());
                    }
                    sparseArray2.put(d.g.tag_user_mute_post_id, postData.getId());
                }
            } else {
                sparseArray2.put(d.g.tag_user_mute_visible, false);
            }
            if (z8) {
                sparseArray2.put(d.g.tag_should_delete_visible, true);
                sparseArray2.put(d.g.tag_manage_user_identity, Integer.valueOf(this.fip));
                sparseArray2.put(d.g.tag_del_post_is_self, Boolean.valueOf(z7));
                sparseArray2.put(d.g.tag_del_post_type, 2);
                sparseArray2.put(d.g.tag_del_post_id, postData.getId());
            } else {
                sparseArray2.put(d.g.tag_should_delete_visible, false);
            }
            if (this.fis && z2 && this.aCq) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.fiv.getLayoutParams();
                layoutParams.topMargin = l.f(this.mContext, d.e.ds32);
                layoutParams.bottomMargin = l.f(this.mContext, d.e.ds8);
                bVar.fiv.setLayoutParams(layoutParams);
            }
            if (this.fis && !z2) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.fiv.getLayoutParams();
                layoutParams2.topMargin = l.f(this.mContext, d.e.ds8);
                layoutParams2.bottomMargin = l.f(this.mContext, d.e.ds8);
                bVar.fiv.setLayoutParams(layoutParams2);
            }
            bVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(PostData postData, boolean z) {
        TbRichText bwY;
        SpannableStringBuilder Jy;
        TbRichTextData tbRichTextData;
        String str;
        String str2;
        SpannableStringBuilder Jy2;
        if (postData != null && (bwY = postData.bwY()) != null) {
            ArrayList<TbRichTextData> Jr = bwY.Jr();
            if (!v.w(Jr)) {
                if (z) {
                    TbRichTextData tbRichTextData2 = Jr.get(Jr.size() - 1);
                    int type = tbRichTextData2 != null ? tbRichTextData2.getType() : -1;
                    if (type == 1) {
                        String str3 = "   " + am.r(postData.getTime());
                        if (Jr.size() > 1) {
                            if ((Jr.get(Jr.size() + (-2)) != null ? Jr.get(Jr.size() - 2).getType() : -1) != type) {
                                str2 = am.r(postData.getTime());
                                Jy2 = tbRichTextData2.Jy();
                                if (bwY.hasAppendTime && Jy2 != 0 && bwY.appendLength <= Jy2.length()) {
                                    Jy2.delete(Jy2.length() - bwY.appendLength, Jy2.length());
                                }
                                String dT = am.dT(str2);
                                if (Jy2 != null) {
                                    Jy2.append((CharSequence) dT);
                                }
                                bwY.hasAppendTime = true;
                                bwY.appendLength = dT.length();
                                tbRichTextData = tbRichTextData2;
                                str = dT;
                            }
                        }
                        str2 = str3;
                        Jy2 = tbRichTextData2.Jy();
                        if (bwY.hasAppendTime) {
                            Jy2.delete(Jy2.length() - bwY.appendLength, Jy2.length());
                        }
                        String dT2 = am.dT(str2);
                        if (Jy2 != null) {
                        }
                        bwY.hasAppendTime = true;
                        bwY.appendLength = dT2.length();
                        tbRichTextData = tbRichTextData2;
                        str = dT2;
                    } else if (bwY.hasAppendTime) {
                        tbRichTextData = tbRichTextData2;
                        str = "";
                    } else {
                        String r = am.r(postData.getTime());
                        tbRichTextData = new TbRichTextData(1);
                        str = am.dT(r);
                        tbRichTextData.append(str);
                        bwY.hasAppendTime = true;
                        bwY.appendLength = str.length();
                        Jr.add(tbRichTextData);
                    }
                    SpannableStringBuilder Jy3 = tbRichTextData.Jy();
                    if (Jy3 != null && str.length() <= Jy3.length()) {
                        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(TbConfig.getContentSizeOfLzl());
                        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(aj.getColor(d.C0096d.cp_cont_d));
                        Jy3.setSpan(absoluteSizeSpan, Jy3.length() - str.length(), Jy3.length(), 33);
                        Jy3.setSpan(foregroundColorSpan, Jy3.length() - str.length(), Jy3.length(), 33);
                        return;
                    }
                    return;
                }
                TbRichTextData tbRichTextData3 = Jr.get(Jr.size() - 1);
                if (bwY.hasAppendTime && tbRichTextData3 != null && (Jy = tbRichTextData3.Jy()) != null && bwY.appendLength <= Jy.length()) {
                    Jy.delete(Jy.length() - bwY.appendLength, Jy.length());
                }
                bwY.hasAppendTime = false;
                bwY.appendLength = 0;
            }
        }
    }

    public void ko(boolean z) {
        this.fis = z;
    }

    public void kp(boolean z) {
        this.aCq = z;
    }

    public void qh(String str) {
        this.mPostId = str;
    }
}
