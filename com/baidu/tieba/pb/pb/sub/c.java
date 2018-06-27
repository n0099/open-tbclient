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
import com.baidu.tbadk.core.data.bc;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.widget.richText.TbRichText;
import com.baidu.tbadk.widget.richText.TbRichTextData;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.d;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
/* loaded from: classes2.dex */
public class c extends BaseAdapter {
    private bc btP;
    protected Context mContext;
    protected ArrayList<PostData> alT = null;
    protected View.OnClickListener fLh = null;
    protected int fLi = 0;
    protected boolean fLj = false;
    protected boolean fLk = false;
    protected boolean cFg = false;
    private boolean mIsFromCDN = true;
    private boolean fLl = false;
    private boolean aMC = false;
    private String mPostId = "";
    private int mSelectedPosition = -1;

    /* loaded from: classes2.dex */
    public static class b {
        public TextView cjf;
        public LinearLayout fLn;
        public View fLo;
        public TbRichTextView fza;
        public int mSkinType = 3;
        public View rootView;
    }

    public c(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public void rb(int i) {
        this.mSelectedPosition = i;
    }

    public int rH(String str) {
        if (this.alT == null) {
            return -1;
        }
        int size = this.alT.size();
        for (int i = 0; i < size; i++) {
            if (this.alT.get(i).getId().equals(str)) {
                return i;
            }
        }
        return -1;
    }

    public void X(bc bcVar) {
        this.btP = bcVar;
    }

    public void setDatas(ArrayList<PostData> arrayList) {
        if (arrayList == null) {
            this.alT = new ArrayList<>();
        } else {
            this.alT = arrayList;
        }
    }

    public void M(View.OnClickListener onClickListener) {
        this.fLh = onClickListener;
    }

    public void B(int i, boolean z) {
        this.fLi = i;
        this.fLj = z;
    }

    public void setHasMoreData(boolean z) {
        this.cFg = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.alT == null) {
            return 0;
        }
        return this.alT.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.alT == null || i < 0 || i >= this.alT.size()) {
            return null;
        }
        return this.alT.get(i);
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
            if (postData.getType() == PostData.gMZ) {
                view = bht();
            } else {
                view = nn();
            }
        }
        if ((view.getTag() instanceof a) && postData.getType() != PostData.gMZ) {
            view = nn();
        }
        if ((view.getTag() instanceof SparseArray) && postData.getType() == PostData.gMZ) {
            view = bht();
        }
        if ((view.getTag() instanceof SparseArray) && (bVar = (b) ((SparseArray) view.getTag()).get(d.g.tag_holder)) != null && postData != null) {
            boolean z = !this.cFg && i + 1 >= getCount();
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

    /* loaded from: classes2.dex */
    public static class a {
        public View bjZ;
        public TextView fLm;
        public View mRootView;
        private int mSkinType = 3;

        public a(Context context, View view) {
            this.mRootView = view;
            this.bjZ = view.findViewById(d.g.divider_line);
            this.fLm = (TextView) view.findViewById(d.g.center_reply_text);
            this.fLm.setTextSize(0, TbConfig.getContentSizeOfLzl());
            onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        }

        public void onChangeSkinType(int i) {
            if (i != this.mSkinType) {
                am.j(this.bjZ, d.C0142d.cp_cont_d);
                am.h(this.fLm, d.C0142d.cp_cont_d);
                am.j(this.fLm, d.C0142d.cp_bg_line_d);
                this.fLm.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, am.v(i, d.f.icon_floor_arrow_n), (Drawable) null);
            }
            this.mSkinType = i;
        }
    }

    public View bht() {
        View inflate = LayoutInflater.from(this.mContext).inflate(d.i.new_sub_pb_list_expand_view, (ViewGroup) null);
        inflate.setTag(new a(this.mContext, inflate));
        return inflate;
    }

    public View nn() {
        b bVar = new b();
        View inflate = LayoutInflater.from(this.mContext).inflate(d.i.new_sub_pb_list_item, (ViewGroup) null);
        bVar.rootView = inflate;
        bVar.fLn = (LinearLayout) inflate.findViewById(d.g.sub_pb_item_columnlayout);
        if (this.fLl) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.fLn.getLayoutParams();
            layoutParams.topMargin = l.e(this.mContext, d.e.ds8);
            layoutParams.bottomMargin = l.e(this.mContext, d.e.ds8);
            bVar.fLn.setLayoutParams(layoutParams);
        }
        bVar.cjf = (TextView) inflate.findViewById(d.g.manage_btn);
        bVar.fza = (TbRichTextView) inflate.findViewById(d.g.new_sub_pb_list_richText);
        bVar.fLo = inflate.findViewById(d.g.divide_bottom_view);
        bVar.fza.getLayoutStrategy().setSupportNoImage();
        if (!this.fLl) {
            bVar.fza.getLayoutStrategy().setLineSpacing(l.e(TbadkCoreApplication.getInst().getContext(), d.e.tbds12), 1.0f);
            bVar.fza.getLayoutStrategy().fV(0);
            bVar.fza.getLayoutStrategy().fT(l.e(this.mContext, d.e.tbds20));
            bVar.fza.getLayoutStrategy().fU(l.e(this.mContext, d.e.tbds3));
        }
        bVar.fza.setSubPbPost(true);
        bVar.fza.setTextColor(am.getColor(d.C0142d.cp_cont_f));
        bVar.fza.setTextSize(TbConfig.getContentSizeOfLzl());
        bVar.fza.setTextCenter(true);
        bVar.cjf.setOnClickListener(this.fLh);
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
                am.j(bVar.rootView, d.C0142d.cp_bg_line_b);
            } else {
                bVar.rootView.setBackgroundResource(0);
            }
            if (postData.bxD()) {
                bVar.fLo.setVisibility(0);
            } else {
                bVar.fLo.setVisibility(8);
            }
            bVar.fza.setPadding(0, 0, 0, 0);
            if (postData.vw() != null) {
                String name_show = postData.vw().getName_show();
                String userId = postData.vw().getUserId();
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
            bVar.fza.setLinkTextColor(am.getColor(d.C0142d.cp_link_tip_c));
            bVar.fza.setTextColor(am.getColor(d.C0142d.cp_cont_f));
            a(postData, this.fLl);
            TbRichText bxE = postData.bxE();
            if (bxE != null) {
                bVar.fza.setVoiceViewRes(d.i.voice_play_btn_new);
                bVar.fza.setIsFromCDN(this.mIsFromCDN);
                if (bVar.mSkinType != TbadkCoreApplication.getInst().getSkinType()) {
                    bxE.isChanged = true;
                }
                bVar.fza.setText(bxE);
            }
            String userId2 = postData.vw().getUserId();
            if (this.fLi != 0) {
                boolean z9 = this.fLi != 1002;
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
            if (!this.fLj) {
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
            bVar.cjf.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            bVar.cjf.setText("");
            bVar.cjf.setContentDescription("");
            am.h(bVar.cjf, d.C0142d.cp_link_tip_c);
            if (z5) {
                bVar.cjf.setVisibility(0);
                bVar.cjf.setText(this.mContext.getString(d.k.manage));
                bVar.cjf.setContentDescription(this.mContext.getString(d.k.manage));
            } else if (z6) {
                bVar.cjf.setVisibility(0);
                bVar.cjf.setText(this.mContext.getString(d.k.mute));
                bVar.cjf.setContentDescription(this.mContext.getString(d.k.mute));
            } else if (z8) {
                bVar.cjf.setVisibility(0);
                if (this.fLi == 1002 && !z7) {
                    bVar.cjf.setText(this.mContext.getString(d.k.report_text));
                } else {
                    bVar.cjf.setText(this.mContext.getString(d.k.delete));
                }
            } else {
                bVar.cjf.setVisibility(8);
            }
            SparseArray sparseArray2 = (SparseArray) bVar.cjf.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                bVar.cjf.setTag(sparseArray2);
            }
            sparseArray2.put(d.g.tag_subpb_main_floor_post_id, this.mPostId);
            if (z5) {
                sparseArray2.put(d.g.tag_should_manage_visible, true);
                sparseArray2.put(d.g.tag_manage_user_identity, Integer.valueOf(this.fLi));
                if (postData.vw() != null) {
                    sparseArray2.put(d.g.tag_forbid_user_name, postData.vw().getUserName());
                    sparseArray2.put(d.g.tag_forbid_user_name_show, postData.vw().getName_show());
                    sparseArray2.put(d.g.tag_forbid_user_portrait, postData.vw().getPortrait());
                }
                sparseArray2.put(d.g.tag_forbid_user_post_id, postData.getId());
            } else {
                sparseArray2.put(d.g.tag_should_manage_visible, false);
            }
            if (z6) {
                if (this.btP != null) {
                    sparseArray2.put(d.g.tag_user_mute_visible, true);
                    sparseArray2.put(d.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (postData.vw() != null) {
                        sparseArray2.put(d.g.tag_user_mute_mute_userid, postData.vw().getUserId());
                        sparseArray2.put(d.g.tag_user_mute_mute_username, postData.vw().getUserName());
                        sparseArray2.put(d.g.tag_user_mute_mute_nameshow, postData.vw().getName_show());
                    }
                    if (this.btP.getId() != null) {
                        sparseArray2.put(d.g.tag_user_mute_thread_id, this.btP.getId());
                    }
                    sparseArray2.put(d.g.tag_user_mute_post_id, postData.getId());
                }
            } else {
                sparseArray2.put(d.g.tag_user_mute_visible, false);
            }
            if (z8) {
                sparseArray2.put(d.g.tag_should_delete_visible, true);
                sparseArray2.put(d.g.tag_manage_user_identity, Integer.valueOf(this.fLi));
                sparseArray2.put(d.g.tag_del_post_is_self, Boolean.valueOf(z7));
                sparseArray2.put(d.g.tag_del_post_type, 2);
                sparseArray2.put(d.g.tag_del_post_id, postData.getId());
            } else {
                sparseArray2.put(d.g.tag_should_delete_visible, false);
            }
            if (this.fLl && z2 && this.aMC) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) bVar.fLn.getLayoutParams();
                layoutParams.topMargin = l.e(this.mContext, d.e.ds32);
                layoutParams.bottomMargin = l.e(this.mContext, d.e.ds8);
                bVar.fLn.setLayoutParams(layoutParams);
            }
            if (this.fLl && !z2) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) bVar.fLn.getLayoutParams();
                layoutParams2.topMargin = l.e(this.mContext, d.e.ds8);
                layoutParams2.bottomMargin = l.e(this.mContext, d.e.ds8);
                bVar.fLn.setLayoutParams(layoutParams2);
            }
            bVar.mSkinType = TbadkCoreApplication.getInst().getSkinType();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x00a0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void a(PostData postData, boolean z) {
        TbRichText bxE;
        SpannableStringBuilder NG;
        TbRichTextData tbRichTextData;
        String str;
        String str2;
        SpannableStringBuilder NG2;
        if (postData != null && (bxE = postData.bxE()) != null) {
            ArrayList<TbRichTextData> Nz = bxE.Nz();
            if (!w.A(Nz)) {
                if (z) {
                    TbRichTextData tbRichTextData2 = Nz.get(Nz.size() - 1);
                    int type = tbRichTextData2 != null ? tbRichTextData2.getType() : -1;
                    if (type == 1) {
                        String str3 = "   " + ap.w(postData.getTime());
                        if (Nz.size() > 1) {
                            if ((Nz.get(Nz.size() + (-2)) != null ? Nz.get(Nz.size() - 2).getType() : -1) != type) {
                                str2 = ap.w(postData.getTime());
                                NG2 = tbRichTextData2.NG();
                                if (bxE.hasAppendTime && NG2 != 0 && bxE.appendLength <= NG2.length()) {
                                    NG2.delete(NG2.length() - bxE.appendLength, NG2.length());
                                }
                                String eK = ap.eK(str2);
                                if (NG2 != null) {
                                    NG2.append((CharSequence) eK);
                                }
                                bxE.hasAppendTime = true;
                                bxE.appendLength = eK.length();
                                tbRichTextData = tbRichTextData2;
                                str = eK;
                            }
                        }
                        str2 = str3;
                        NG2 = tbRichTextData2.NG();
                        if (bxE.hasAppendTime) {
                            NG2.delete(NG2.length() - bxE.appendLength, NG2.length());
                        }
                        String eK2 = ap.eK(str2);
                        if (NG2 != null) {
                        }
                        bxE.hasAppendTime = true;
                        bxE.appendLength = eK2.length();
                        tbRichTextData = tbRichTextData2;
                        str = eK2;
                    } else if (bxE.hasAppendTime) {
                        tbRichTextData = tbRichTextData2;
                        str = "";
                    } else {
                        String w = ap.w(postData.getTime());
                        tbRichTextData = new TbRichTextData(1);
                        str = ap.eK(w);
                        tbRichTextData.append(str);
                        bxE.hasAppendTime = true;
                        bxE.appendLength = str.length();
                        Nz.add(tbRichTextData);
                    }
                    SpannableStringBuilder NG3 = tbRichTextData.NG();
                    if (NG3 != null && str.length() <= NG3.length()) {
                        AbsoluteSizeSpan absoluteSizeSpan = new AbsoluteSizeSpan(TbConfig.getContentSizeOfLzl());
                        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(am.getColor(d.C0142d.cp_cont_d));
                        NG3.setSpan(absoluteSizeSpan, NG3.length() - str.length(), NG3.length(), 33);
                        NG3.setSpan(foregroundColorSpan, NG3.length() - str.length(), NG3.length(), 33);
                        return;
                    }
                    return;
                }
                TbRichTextData tbRichTextData3 = Nz.get(Nz.size() - 1);
                if (bxE.hasAppendTime && tbRichTextData3 != null && (NG = tbRichTextData3.NG()) != null && bxE.appendLength <= NG.length()) {
                    NG.delete(NG.length() - bxE.appendLength, NG.length());
                }
                bxE.hasAppendTime = false;
                bxE.appendLength = 0;
            }
        }
    }

    public void kY(boolean z) {
        this.fLl = z;
    }

    public void kZ(boolean z) {
        this.aMC = z;
    }

    public void rI(String str) {
        this.mPostId = str;
    }
}
