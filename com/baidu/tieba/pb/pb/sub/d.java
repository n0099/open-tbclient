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
import com.baidu.tbadk.core.data.bh;
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
    private bh biQ;
    protected Context mContext;
    protected ArrayList<PostData> acc = null;
    protected View.OnClickListener fac = null;
    protected int fad = 0;
    protected boolean fae = false;
    protected boolean faf = false;
    protected boolean caG = false;
    private boolean mIsFromCDN = true;
    private boolean fag = false;
    private boolean eZp = false;
    private String mPostId = "";
    private int mSelectedPosition = -1;

    public d(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void qc(int i) {
        this.mSelectedPosition = i;
    }

    public int pP(String str) {
        if (this.acc == null) {
            return -1;
        }
        int size = this.acc.size();
        for (int i = 0; i < size; i++) {
            if (this.acc.get(i).getId().equals(str)) {
                return i;
            }
        }
        return -1;
    }

    public void M(bh bhVar) {
        this.biQ = bhVar;
    }

    public void setDatas(ArrayList<PostData> arrayList) {
        if (arrayList == null) {
            this.acc = new ArrayList<>();
        } else {
            this.acc = arrayList;
        }
    }

    public void F(View.OnClickListener onClickListener) {
        this.fac = onClickListener;
    }

    public void y(int i, boolean z) {
        this.fad = i;
        this.fae = z;
    }

    public void setHasMoreData(boolean z) {
        this.caG = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.acc == null) {
            return 0;
        }
        return this.acc.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.acc == null || i < 0 || i >= this.acc.size()) {
            return null;
        }
        return this.acc.get(i);
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
            if (postData.getType() == PostData.gpp) {
                view = aWz();
            } else {
                view = kX();
            }
        }
        if ((view.getTag() instanceof a) && postData.getType() != PostData.gpp) {
            view = kX();
        }
        if ((view.getTag() instanceof SparseArray) && postData.getType() == PostData.gpp) {
            view = aWz();
        }
        if ((view.getTag() instanceof SparseArray) && (bVar = (b) ((SparseArray) view.getTag()).get(d.g.tag_holder)) != null && postData != null) {
            boolean z = !this.caG && i + 1 >= getCount();
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
        public TextView bGI;
        public TbRichTextView eIo;
        public LinearLayout faj;
        public View fak;
        public int mSkinType = 3;
        public View rootView;

        public b() {
        }
    }

    /* loaded from: classes.dex */
    public class a {
        public View aXa;
        public TextView fah;
        public View mRootView;
        private int mSkinType = 3;

        public a(Context context, View view) {
            this.mRootView = view;
            this.aXa = view.findViewById(d.g.divider_line);
            this.fah = (TextView) view.findViewById(d.g.center_reply_text);
            this.fah.setTextSize(0, TbConfig.getContentSizeOfLzl());
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }

        public void onChangeSkinType(int i) {
            if (i != this.mSkinType) {
                aj.k(this.aXa, d.C0080d.cp_cont_d);
                aj.i(this.fah, d.C0080d.cp_cont_d);
                aj.k(this.fah, d.C0080d.cp_bg_line_d);
                this.fah.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.u(i, d.f.icon_floor_arrow_n), (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public View aWz() {
        View inflate = LayoutInflater.from(this.mContext).inflate(d.h.new_sub_pb_list_expand_view, (ViewGroup) null);
        inflate.setTag(new a(this.mContext, inflate));
        return inflate;
    }

    public View kX() {
        b bVar = new b();
        View inflate = LayoutInflater.from(this.mContext).inflate(d.h.new_sub_pb_list_item, (ViewGroup) null);
        bVar.rootView = inflate;
        bVar.faj = (LinearLayout) inflate.findViewById(d.g.sub_pb_item_columnlayout);
        if (this.fag) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.faj.getLayoutParams();
            layoutParams.topMargin = l.f(this.mContext, d.e.ds8);
            layoutParams.bottomMargin = l.f(this.mContext, d.e.ds8);
            bVar.faj.setLayoutParams(layoutParams);
        }
        bVar.bGI = (TextView) inflate.findViewById(d.g.manage_btn);
        bVar.eIo = (TbRichTextView) inflate.findViewById(d.g.new_sub_pb_list_richText);
        bVar.fak = inflate.findViewById(d.g.divide_bottom_view);
        bVar.eIo.getLayoutStrategy().IH();
        bVar.eIo.setSubPbPost(true);
        bVar.eIo.setTextColor(aj.getColor(d.C0080d.cp_cont_f));
        bVar.eIo.setTextSize(TbConfig.getContentSizeOfLzl());
        bVar.eIo.setTextCenter(true);
        bVar.bGI.setOnClickListener(this.fac);
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
                aj.k(bVar.rootView, d.C0080d.cp_bg_line_b);
            } else {
                bVar.rootView.setBackgroundResource(0);
            }
            if (postData.buv()) {
                bVar.fak.setVisibility(0);
            } else {
                bVar.fak.setVisibility(8);
            }
            bVar.eIo.setPadding(0, 0, 0, 0);
            if (postData.rt() != null) {
                String name_show = postData.rt().getName_show();
                String userId = postData.rt().getUserId();
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
            bVar.eIo.setLinkTextColor(aj.getColor(d.C0080d.cp_link_tip_c));
            bVar.eIo.setTextColor(aj.getColor(d.C0080d.cp_cont_f));
            a(postData, this.fag);
            TbRichText aEt = postData.aEt();
            if (aEt != null) {
                bVar.eIo.setVoiceViewRes(d.h.voice_play_btn_new);
                bVar.eIo.setIsFromCDN(this.mIsFromCDN);
                if (bVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                    aEt.isChanged = true;
                }
                bVar.eIo.setText(aEt);
            }
            String userId2 = postData.rt().getUserId();
            if (this.fad != 0) {
                boolean z9 = this.fad != 1002;
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
            if (!this.fae) {
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
            bVar.bGI.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            bVar.bGI.setText("");
            bVar.bGI.setContentDescription("");
            aj.i(bVar.bGI, d.C0080d.cp_link_tip_c);
            if (z5) {
                bVar.bGI.setVisibility(0);
                bVar.bGI.setText(this.mContext.getString(d.j.manage));
                bVar.bGI.setContentDescription(this.mContext.getString(d.j.manage));
            } else if (z6) {
                bVar.bGI.setVisibility(0);
                bVar.bGI.setText(this.mContext.getString(d.j.mute));
                bVar.bGI.setContentDescription(this.mContext.getString(d.j.mute));
            } else if (z8) {
                bVar.bGI.setVisibility(0);
                if (this.fad == 1002 && !z7) {
                    bVar.bGI.setText(this.mContext.getString(d.j.report_text));
                } else {
                    bVar.bGI.setText(this.mContext.getString(d.j.delete));
                }
            } else {
                bVar.bGI.setVisibility(8);
            }
            SparseArray sparseArray2 = (SparseArray) bVar.bGI.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                bVar.bGI.setTag(sparseArray2);
            }
            sparseArray2.put(d.g.tag_subpb_main_floor_post_id, this.mPostId);
            if (z5) {
                sparseArray2.put(d.g.tag_should_manage_visible, true);
                sparseArray2.put(d.g.tag_manage_user_identity, Integer.valueOf(this.fad));
                sparseArray2.put(d.g.tag_forbid_user_name, postData.rt().getUserName());
                sparseArray2.put(d.g.tag_forbid_user_post_id, postData.getId());
            } else {
                sparseArray2.put(d.g.tag_should_manage_visible, false);
            }
            if (z6) {
                if (this.biQ != null) {
                    sparseArray2.put(d.g.tag_user_mute_visible, true);
                    sparseArray2.put(d.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (postData.rt() != null) {
                        sparseArray2.put(d.g.tag_user_mute_mute_userid, postData.rt().getUserId());
                        sparseArray2.put(d.g.tag_user_mute_mute_username, postData.rt().getUserName());
                    }
                    if (this.biQ.getId() != null) {
                        sparseArray2.put(d.g.tag_user_mute_thread_id, this.biQ.getId());
                    }
                    sparseArray2.put(d.g.tag_user_mute_post_id, postData.getId());
                }
            } else {
                sparseArray2.put(d.g.tag_user_mute_visible, false);
            }
            if (z8) {
                sparseArray2.put(d.g.tag_should_delete_visible, true);
                sparseArray2.put(d.g.tag_manage_user_identity, Integer.valueOf(this.fad));
                sparseArray2.put(d.g.tag_del_post_is_self, Boolean.valueOf(z7));
                sparseArray2.put(d.g.tag_del_post_type, 2);
                sparseArray2.put(d.g.tag_del_post_id, postData.getId());
            } else {
                sparseArray2.put(d.g.tag_should_delete_visible, false);
            }
            if (this.fag && z2 && this.eZp) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.faj.getLayoutParams();
                layoutParams.topMargin = l.f(this.mContext, d.e.ds32);
                layoutParams.bottomMargin = l.f(this.mContext, d.e.ds8);
                bVar.faj.setLayoutParams(layoutParams);
            }
            if (this.fag && !z2) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.faj.getLayoutParams();
                layoutParams2.topMargin = l.f(this.mContext, d.e.ds8);
                layoutParams2.bottomMargin = l.f(this.mContext, d.e.ds8);
                bVar.faj.setLayoutParams(layoutParams2);
            }
            if (this.fag) {
                bVar.rootView.setPadding(bVar.rootView.getPaddingLeft(), bVar.rootView.getPaddingTop(), bVar.rootView.getPaddingRight(), l.f(this.mContext, d.e.ds12));
            }
            bVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(PostData postData, boolean z) {
        TbRichText aEt;
        SpannableStringBuilder IP;
        TbRichTextData tbRichTextData;
        String str;
        String str2;
        SpannableStringBuilder IP2;
        if (postData != null && (aEt = postData.aEt()) != null) {
            ArrayList<TbRichTextData> II = aEt.II();
            if (!v.v(II)) {
                if (z) {
                    TbRichTextData tbRichTextData2 = II.get(II.size() - 1);
                    int type = tbRichTextData2 != null ? tbRichTextData2.getType() : -1;
                    if (type == 1) {
                        String str3 = "   " + am.r(postData.getTime());
                        if (II.size() > 1) {
                            if ((II.get(II.size() + (-2)) != null ? II.get(II.size() - 2).getType() : -1) != type) {
                                str2 = am.r(postData.getTime());
                                IP2 = tbRichTextData2.IP();
                                if (aEt.hasAppendTime && IP2 != 0 && aEt.appendLength <= IP2.length()) {
                                    IP2.delete(IP2.length() - aEt.appendLength, IP2.length());
                                }
                                String dR = am.dR(str2);
                                if (IP2 != null) {
                                    IP2.append((CharSequence) dR);
                                }
                                aEt.hasAppendTime = true;
                                aEt.appendLength = dR.length();
                                tbRichTextData = tbRichTextData2;
                                str = dR;
                            }
                        }
                        str2 = str3;
                        IP2 = tbRichTextData2.IP();
                        if (aEt.hasAppendTime) {
                            IP2.delete(IP2.length() - aEt.appendLength, IP2.length());
                        }
                        String dR2 = am.dR(str2);
                        if (IP2 != null) {
                        }
                        aEt.hasAppendTime = true;
                        aEt.appendLength = dR2.length();
                        tbRichTextData = tbRichTextData2;
                        str = dR2;
                    } else if (aEt.hasAppendTime) {
                        tbRichTextData = tbRichTextData2;
                        str = "";
                    } else {
                        String r = am.r(postData.getTime());
                        tbRichTextData = new TbRichTextData(1);
                        str = am.dR(r);
                        tbRichTextData.append(str);
                        aEt.hasAppendTime = true;
                        aEt.appendLength = str.length();
                        II.add(tbRichTextData);
                    }
                    SpannableStringBuilder IP3 = tbRichTextData.IP();
                    if (IP3 != null && str.length() <= IP3.length()) {
                        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(TbConfig.getContentSizeOfLzl());
                        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(aj.getColor(d.C0080d.cp_cont_d));
                        IP3.setSpan(absoluteSizeSpan, IP3.length() - str.length(), IP3.length(), 33);
                        IP3.setSpan(foregroundColorSpan, IP3.length() - str.length(), IP3.length(), 33);
                        return;
                    }
                    return;
                }
                TbRichTextData tbRichTextData3 = II.get(II.size() - 1);
                if (aEt.hasAppendTime && tbRichTextData3 != null && (IP = tbRichTextData3.IP()) != null && aEt.appendLength <= IP.length()) {
                    IP.delete(IP.length() - aEt.appendLength, IP.length());
                }
                aEt.hasAppendTime = false;
                aEt.appendLength = 0;
            }
        }
    }

    public void jJ(boolean z) {
        this.fag = z;
    }

    public void jK(boolean z) {
        this.eZp = z;
    }

    public void pQ(String str) {
        this.mPostId = str;
    }
}
