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
import com.baidu.adp.lib.util.k;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.bj;
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
    private bj bgF;
    protected Context mContext;
    protected ArrayList<PostData> abO = null;
    protected View.OnClickListener eXz = null;
    protected int eXA = 0;
    protected boolean eXB = false;
    protected boolean eKz = false;
    protected boolean bTD = false;
    private boolean mIsFromCDN = true;
    private boolean eXC = false;
    private boolean eWI = false;
    private String mPostId = "";
    private int mSelectedPosition = -1;

    public d(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void pP(int i) {
        this.mSelectedPosition = i;
    }

    public int pC(String str) {
        if (this.abO == null) {
            return -1;
        }
        int size = this.abO.size();
        for (int i = 0; i < size; i++) {
            if (this.abO.get(i).getId().equals(str)) {
                return i;
            }
        }
        return -1;
    }

    public void Z(bj bjVar) {
        this.bgF = bjVar;
    }

    public void setDatas(ArrayList<PostData> arrayList) {
        if (arrayList == null) {
            this.abO = new ArrayList<>();
        } else {
            this.abO = arrayList;
        }
    }

    public void C(View.OnClickListener onClickListener) {
        this.eXz = onClickListener;
    }

    public void z(int i, boolean z) {
        this.eXA = i;
        this.eXB = z;
    }

    public void setHasMoreData(boolean z) {
        this.bTD = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.abO == null) {
            return 0;
        }
        return this.abO.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.abO == null || i < 0 || i >= this.abO.size()) {
            return null;
        }
        return this.abO.get(i);
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
            if (postData.getType() == PostData.gjm) {
                view = aVt();
            } else {
                view = lb();
            }
        }
        if ((view.getTag() instanceof a) && postData.getType() != PostData.gjm) {
            view = lb();
        }
        if ((view.getTag() instanceof SparseArray) && postData.getType() == PostData.gjm) {
            view = aVt();
        }
        if ((view.getTag() instanceof SparseArray) && (bVar = (b) ((SparseArray) view.getTag()).get(d.h.tag_holder)) != null && postData != null) {
            boolean z = !this.bTD && i + 1 >= getCount();
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
        public TextView byM;
        public TbRichTextView eHc;
        public LinearLayout eXF;
        public View eXG;
        public int mSkinType = 3;
        public View rootView;

        public b() {
        }
    }

    /* loaded from: classes.dex */
    public class a {
        public View aVj;
        public TextView eXD;
        public View mRootView;
        private int mSkinType = 3;

        public a(Context context, View view) {
            this.mRootView = view;
            this.aVj = view.findViewById(d.h.divider_line);
            this.eXD = (TextView) view.findViewById(d.h.center_reply_text);
            this.eXD.setTextSize(0, TbConfig.getContentSizeOfLzl());
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }

        public void onChangeSkinType(int i) {
            if (i != this.mSkinType) {
                aj.k(this.aVj, d.e.cp_cont_d);
                aj.i(this.eXD, d.e.cp_cont_d);
                aj.k(this.eXD, d.e.cp_bg_line_d);
                this.eXD.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, aj.u(i, d.g.icon_floor_arrow_n), (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public View aVt() {
        View inflate = LayoutInflater.from(this.mContext).inflate(d.j.new_sub_pb_list_expand_view, (ViewGroup) null);
        inflate.setTag(new a(this.mContext, inflate));
        return inflate;
    }

    public View lb() {
        b bVar = new b();
        View inflate = LayoutInflater.from(this.mContext).inflate(d.j.new_sub_pb_list_item, (ViewGroup) null);
        bVar.rootView = inflate;
        bVar.eXF = (LinearLayout) inflate.findViewById(d.h.sub_pb_item_columnlayout);
        if (this.eXC) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.eXF.getLayoutParams();
            layoutParams.topMargin = k.f(this.mContext, d.f.ds8);
            layoutParams.bottomMargin = k.f(this.mContext, d.f.ds8);
            bVar.eXF.setLayoutParams(layoutParams);
        }
        bVar.byM = (TextView) inflate.findViewById(d.h.manage_btn);
        bVar.eHc = (TbRichTextView) inflate.findViewById(d.h.new_sub_pb_list_richText);
        bVar.eXG = inflate.findViewById(d.h.divide_bottom_view);
        bVar.eHc.Jk();
        bVar.eHc.setSubPbPost(true);
        bVar.eHc.setTextColor(aj.getColor(d.e.cp_cont_f));
        bVar.eHc.setTextSize(TbConfig.getContentSizeOfLzl());
        bVar.eHc.setTextCenter(true);
        bVar.byM.setOnClickListener(this.eXz);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(d.h.tag_holder, bVar);
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
                aj.k(bVar.rootView, d.e.cp_bg_line_b);
            } else {
                bVar.rootView.setBackgroundResource(0);
            }
            if (postData.bsA()) {
                bVar.eXG.setVisibility(0);
            } else {
                bVar.eXG.setVisibility(8);
            }
            bVar.eHc.setPadding(0, 0, 0, 0);
            if (postData.getAuthor() != null) {
                String name_show = postData.getAuthor().getName_show();
                String userId = postData.getAuthor().getUserId();
                SparseArray sparseArray = (SparseArray) bVar.rootView.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    bVar.rootView.setTag(sparseArray);
                }
                sparseArray.put(d.h.tag_photo_username, name_show);
                sparseArray.put(d.h.tag_photo_userid, userId);
                sparseArray.put(d.h.tag_clip_board, postData);
                sparseArray.put(d.h.tag_is_subpb, true);
            }
            bVar.eHc.setLinkTextColor(aj.getColor(d.e.cp_link_tip_c));
            bVar.eHc.setTextColor(aj.getColor(d.e.cp_cont_f));
            b(postData, this.eXC);
            TbRichText aDr = postData.aDr();
            if (aDr != null) {
                bVar.eHc.setVoiceViewRes(d.j.voice_play_btn_new);
                bVar.eHc.setIsFromCDN(this.mIsFromCDN);
                if (bVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                    aDr.isChanged = true;
                }
                bVar.eHc.setText(aDr);
            }
            String userId2 = postData.getAuthor().getUserId();
            if (this.eXA != 0) {
                boolean z9 = userId2 == null || !userId2.equals(TbadkCoreApplication.getCurrentAccount());
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
            if (!this.eXB) {
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
            bVar.byM.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            bVar.byM.setText("");
            bVar.byM.setContentDescription("");
            aj.i(bVar.byM, d.e.cp_link_tip_c);
            if (z5) {
                bVar.byM.setVisibility(0);
                bVar.byM.setText(this.mContext.getString(d.l.manage));
                bVar.byM.setContentDescription(this.mContext.getString(d.l.manage));
            } else if (z6) {
                bVar.byM.setVisibility(0);
                bVar.byM.setText(this.mContext.getString(d.l.mute));
                bVar.byM.setContentDescription(this.mContext.getString(d.l.mute));
            } else if (z8) {
                bVar.byM.setVisibility(0);
                bVar.byM.setText(this.mContext.getString(d.l.delete));
            } else {
                bVar.byM.setVisibility(8);
            }
            SparseArray sparseArray2 = (SparseArray) bVar.byM.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                bVar.byM.setTag(sparseArray2);
            }
            sparseArray2.put(d.h.tag_subpb_main_floor_post_id, this.mPostId);
            if (z5) {
                sparseArray2.put(d.h.tag_should_manage_visible, true);
                sparseArray2.put(d.h.tag_manage_user_identity, Integer.valueOf(this.eXA));
                sparseArray2.put(d.h.tag_forbid_user_name, postData.getAuthor().getUserName());
                sparseArray2.put(d.h.tag_forbid_user_post_id, postData.getId());
            } else {
                sparseArray2.put(d.h.tag_should_manage_visible, false);
            }
            if (z6) {
                if (this.bgF != null) {
                    sparseArray2.put(d.h.tag_user_mute_visible, true);
                    sparseArray2.put(d.h.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (postData.getAuthor() != null) {
                        sparseArray2.put(d.h.tag_user_mute_mute_userid, postData.getAuthor().getUserId());
                        sparseArray2.put(d.h.tag_user_mute_mute_username, postData.getAuthor().getUserName());
                    }
                    if (this.bgF.getId() != null) {
                        sparseArray2.put(d.h.tag_user_mute_thread_id, this.bgF.getId());
                    }
                    sparseArray2.put(d.h.tag_user_mute_post_id, postData.getId());
                }
            } else {
                sparseArray2.put(d.h.tag_user_mute_visible, false);
            }
            if (z8) {
                sparseArray2.put(d.h.tag_should_delete_visible, true);
                sparseArray2.put(d.h.tag_manage_user_identity, Integer.valueOf(this.eXA));
                sparseArray2.put(d.h.tag_del_post_is_self, Boolean.valueOf(z7));
                sparseArray2.put(d.h.tag_del_post_type, 2);
                sparseArray2.put(d.h.tag_del_post_id, postData.getId());
            } else {
                sparseArray2.put(d.h.tag_should_delete_visible, false);
            }
            if (this.eXC && z2 && this.eWI) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.eXF.getLayoutParams();
                layoutParams.topMargin = k.f(this.mContext, d.f.ds32);
                layoutParams.bottomMargin = k.f(this.mContext, d.f.ds8);
                bVar.eXF.setLayoutParams(layoutParams);
            }
            if (this.eXC && !z2) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.eXF.getLayoutParams();
                layoutParams2.topMargin = k.f(this.mContext, d.f.ds8);
                layoutParams2.bottomMargin = k.f(this.mContext, d.f.ds8);
                bVar.eXF.setLayoutParams(layoutParams2);
            }
            if (this.eXC) {
                bVar.rootView.setPadding(bVar.rootView.getPaddingLeft(), bVar.rootView.getPaddingTop(), bVar.rootView.getPaddingRight(), k.f(this.mContext, d.f.ds12));
            }
            bVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void b(PostData postData, boolean z) {
        TbRichText aDr;
        SpannableStringBuilder IC;
        TbRichTextData tbRichTextData;
        String str;
        String str2;
        SpannableStringBuilder IC2;
        if (postData != null && (aDr = postData.aDr()) != null) {
            ArrayList<TbRichTextData> Iv = aDr.Iv();
            if (!v.v(Iv)) {
                if (z) {
                    TbRichTextData tbRichTextData2 = Iv.get(Iv.size() - 1);
                    int type = tbRichTextData2 != null ? tbRichTextData2.getType() : -1;
                    if (type == 1) {
                        String str3 = "   " + am.r(postData.getTime());
                        if (Iv.size() > 1) {
                            if ((Iv.get(Iv.size() + (-2)) != null ? Iv.get(Iv.size() - 2).getType() : -1) != type) {
                                str2 = am.r(postData.getTime());
                                IC2 = tbRichTextData2.IC();
                                if (aDr.hasAppendTime && IC2 != 0 && aDr.appendLength <= IC2.length()) {
                                    IC2.delete(IC2.length() - aDr.appendLength, IC2.length());
                                }
                                String dT = am.dT(str2);
                                if (IC2 != null) {
                                    IC2.append((CharSequence) dT);
                                }
                                aDr.hasAppendTime = true;
                                aDr.appendLength = dT.length();
                                tbRichTextData = tbRichTextData2;
                                str = dT;
                            }
                        }
                        str2 = str3;
                        IC2 = tbRichTextData2.IC();
                        if (aDr.hasAppendTime) {
                            IC2.delete(IC2.length() - aDr.appendLength, IC2.length());
                        }
                        String dT2 = am.dT(str2);
                        if (IC2 != null) {
                        }
                        aDr.hasAppendTime = true;
                        aDr.appendLength = dT2.length();
                        tbRichTextData = tbRichTextData2;
                        str = dT2;
                    } else if (aDr.hasAppendTime) {
                        tbRichTextData = tbRichTextData2;
                        str = "";
                    } else {
                        String r = am.r(postData.getTime());
                        tbRichTextData = new TbRichTextData(1);
                        str = am.dT(r);
                        tbRichTextData.append(str);
                        aDr.hasAppendTime = true;
                        aDr.appendLength = str.length();
                        Iv.add(tbRichTextData);
                    }
                    SpannableStringBuilder IC3 = tbRichTextData.IC();
                    if (IC3 != null && str.length() <= IC3.length()) {
                        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(TbConfig.getContentSizeOfLzl());
                        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(aj.getColor(d.e.cp_cont_d));
                        IC3.setSpan(absoluteSizeSpan, IC3.length() - str.length(), IC3.length(), 33);
                        IC3.setSpan(foregroundColorSpan, IC3.length() - str.length(), IC3.length(), 33);
                        return;
                    }
                    return;
                }
                TbRichTextData tbRichTextData3 = Iv.get(Iv.size() - 1);
                if (aDr.hasAppendTime && tbRichTextData3 != null && (IC = tbRichTextData3.IC()) != null && aDr.appendLength <= IC.length()) {
                    IC.delete(IC.length() - aDr.appendLength, IC.length());
                }
                aDr.hasAppendTime = false;
                aDr.appendLength = 0;
            }
        }
    }

    public void kc(boolean z) {
        this.eXC = z;
    }

    public void kd(boolean z) {
        this.eWI = z;
    }

    public void pD(String str) {
        this.mPostId = str;
    }
}
