package com.baidu.tieba.pb.pb.sub;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.style.TextAppearanceSpan;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.n;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class al extends BaseAdapter {
    private com.baidu.tbadk.core.data.z aZu;
    protected Context mContext;
    protected ArrayList<com.baidu.tieba.tbadkCore.data.o> XX = null;
    protected View.OnClickListener cHE = null;
    protected int cHF = 0;
    protected boolean cHG = false;
    protected boolean cAl = false;
    protected boolean cHH = false;
    private boolean mIsFromCDN = true;

    public al(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public int kP(String str) {
        if (this.XX == null) {
            return -1;
        }
        int size = this.XX.size();
        for (int i = 0; i < size; i++) {
            if (this.XX.get(i).getId().equals(str)) {
                return i;
            }
        }
        return -1;
    }

    public void e(com.baidu.tbadk.core.data.z zVar) {
        this.aZu = zVar;
    }

    public void setDatas(ArrayList<com.baidu.tieba.tbadkCore.data.o> arrayList) {
        if (arrayList == null) {
            this.XX = new ArrayList<>();
        } else {
            this.XX = arrayList;
        }
    }

    public void D(View.OnClickListener onClickListener) {
        this.cHE = onClickListener;
    }

    public void q(int i, boolean z) {
        this.cHF = i;
        this.cHG = z;
    }

    public void eV(boolean z) {
        this.cAl = false;
    }

    public void setHasMoreData(boolean z) {
        this.cHH = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.XX == null) {
            return 0;
        }
        return this.XX.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.XX == null || i < 0 || i >= this.XX.size()) {
            return null;
        }
        return this.XX.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = nv();
        }
        a aVar = (a) ((SparseArray) view.getTag()).get(n.f.tag_holder);
        if (getItem(i) != null) {
            a(aVar, (com.baidu.tieba.tbadkCore.data.o) getItem(i), !(!this.cHH && i + 1 >= getCount()), i == 0);
        }
        return view;
    }

    /* loaded from: classes.dex */
    public class a {
        public LinearLayout cHI;
        public TextView cHJ;
        public TbRichTextView czX;
        public View rootView;

        public a() {
        }
    }

    public View nv() {
        a aVar = new a();
        View inflate = LayoutInflater.from(this.mContext).inflate(n.g.new_sub_pb_list_item, (ViewGroup) null);
        aVar.rootView = inflate;
        aVar.cHI = (LinearLayout) inflate.findViewById(n.f.sub_pb_item_columnlayout);
        aVar.cHJ = (TextView) inflate.findViewById(n.f.manage_btn);
        aVar.czX = (TbRichTextView) inflate.findViewById(n.f.new_sub_pb_list_richText);
        aVar.czX.Go();
        aVar.czX.setLineSpacing(1.0f);
        aVar.czX.setTextSize(TbConfig.getContentSizeOfLzl(this.mContext));
        aVar.czX.setTextColor(as.getColor(n.c.gray_day_3));
        aVar.cHJ.setOnClickListener(this.cHE);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(n.f.tag_holder, aVar);
        inflate.setTag(sparseArray);
        return inflate;
    }

    public void a(a aVar, com.baidu.tieba.tbadkCore.data.o oVar, boolean z, boolean z2) {
        boolean z3;
        boolean z4;
        com.baidu.tbadk.widget.richText.c cVar;
        TextAppearanceSpan textAppearanceSpan;
        if (aVar != null && oVar != null) {
            aVar.czX.setPadding(0, 0, 0, 0);
            int skinType = TbadkCoreApplication.m411getInst().getSkinType();
            if (oVar.getAuthor() != null) {
                String userName = oVar.getAuthor().getUserName();
                SparseArray sparseArray = (SparseArray) aVar.rootView.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    aVar.rootView.setTag(sparseArray);
                }
                sparseArray.put(n.f.tag_photo_username, userName);
                sparseArray.put(n.f.tag_clip_board, oVar);
                sparseArray.put(n.f.tag_is_subpb, true);
            }
            aVar.czX.setLinkTextColor(as.getColor(n.c.cp_link_tip_c));
            com.baidu.tbadk.widget.richText.a aDe = oVar.aDe();
            if (aDe != null) {
                ArrayList<com.baidu.tbadk.widget.richText.c> FL = aDe.FL();
                if (FL.size() > 0) {
                    com.baidu.tbadk.widget.richText.c cVar2 = FL.get(FL.size() - 1);
                    int type = cVar2.getType();
                    String str = "";
                    if (type == 1) {
                        String s = (FL.size() <= 1 || FL.get(FL.size() + (-2)).getType() == type) ? "  " + ax.s(oVar.getTime()) : ax.s(oVar.getTime());
                        SpannableStringBuilder FR = cVar2.FR();
                        if (aDe.aCM) {
                            FR.delete(FR.length() - aDe.aCN, FR.length());
                        }
                        str = ax.dw(s);
                        FR.append((CharSequence) str);
                        aDe.aCM = true;
                        aDe.aCN = str.length();
                        cVar = cVar2;
                    } else if (aDe.aCM) {
                        cVar = cVar2;
                    } else {
                        String s2 = ax.s(oVar.getTime());
                        com.baidu.tbadk.widget.richText.c cVar3 = new com.baidu.tbadk.widget.richText.c(1);
                        String dw = ax.dw(s2);
                        cVar3.append(dw);
                        aDe.aCM = true;
                        aDe.aCN = dw.length();
                        FL.add(cVar3);
                        cVar = cVar3;
                        str = dw;
                    }
                    if (skinType == 1) {
                        textAppearanceSpan = new TextAppearanceSpan(this.mContext, n.j.subtext_1);
                    } else {
                        textAppearanceSpan = new TextAppearanceSpan(this.mContext, n.j.subtext);
                    }
                    SpannableStringBuilder FR2 = cVar.FR();
                    FR2.setSpan(textAppearanceSpan, FR2.length() - str.length(), FR2.length(), 33);
                }
                aVar.czX.setVoiceViewRes(n.g.voice_play_btn);
                aVar.czX.setIsFromCDN(this.mIsFromCDN);
                aVar.czX.setText(oVar.aDe());
            }
            boolean z5 = false;
            boolean z6 = false;
            boolean z7 = false;
            String userId = oVar.getAuthor().getUserId();
            if (this.cHF != 0) {
                z5 = true;
                z6 = true;
                if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z5 = false;
                }
                if (userId == null || userId.equals("0") || userId.length() == 0) {
                    z5 = false;
                }
            }
            if (!this.cHG) {
                z3 = false;
            } else if (userId == null || !userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                z3 = true;
                z6 = true;
            } else {
                z3 = false;
                z6 = true;
            }
            if (userId == null || !userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                z4 = z6;
            } else {
                z4 = true;
                z7 = true;
            }
            if (z5) {
                aVar.cHJ.setVisibility(0);
                aVar.cHJ.setCompoundDrawablesWithIntrinsicBounds(as.getDrawable(n.e.icon_floor_manage_n), (Drawable) null, (Drawable) null, (Drawable) null);
            } else if (z3) {
                aVar.cHJ.setVisibility(0);
                aVar.cHJ.setCompoundDrawablesWithIntrinsicBounds(as.getDrawable(n.e.icon_pb_louzhonglou_gag), (Drawable) null, (Drawable) null, (Drawable) null);
            } else if (z4) {
                aVar.cHJ.setVisibility(0);
                aVar.cHJ.setCompoundDrawablesWithIntrinsicBounds(as.getDrawable(n.e.icon_floor_delete_n), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                aVar.cHJ.setVisibility(8);
            }
            SparseArray sparseArray2 = (SparseArray) aVar.cHJ.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                aVar.cHJ.setTag(sparseArray2);
            }
            if (z5) {
                sparseArray2.put(n.f.tag_should_manage_visible, true);
                sparseArray2.put(n.f.tag_manage_user_identity, Integer.valueOf(this.cHF));
                sparseArray2.put(n.f.tag_forbid_user_name, oVar.getAuthor().getUserName());
                sparseArray2.put(n.f.tag_forbid_user_post_id, oVar.getId());
            } else {
                sparseArray2.put(n.f.tag_should_manage_visible, false);
            }
            if (z3) {
                if (this.aZu != null) {
                    sparseArray2.put(n.f.tag_user_mute_visible, true);
                    sparseArray2.put(n.f.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (oVar.getAuthor() != null) {
                        sparseArray2.put(n.f.tag_user_mute_mute_userid, oVar.getAuthor().getUserId());
                        sparseArray2.put(n.f.tag_user_mute_mute_username, oVar.getAuthor().getUserName());
                    }
                    if (this.aZu.getId() != null) {
                        sparseArray2.put(n.f.tag_user_mute_thread_id, this.aZu.getId());
                    }
                    sparseArray2.put(n.f.tag_user_mute_post_id, oVar.getId());
                }
            } else {
                sparseArray2.put(n.f.tag_user_mute_visible, false);
            }
            if (z4) {
                sparseArray2.put(n.f.tag_should_delete_visible, true);
                sparseArray2.put(n.f.tag_manage_user_identity, Integer.valueOf(this.cHF));
                sparseArray2.put(n.f.tag_del_post_is_self, Boolean.valueOf(z7));
                sparseArray2.put(n.f.tag_del_post_type, 2);
                sparseArray2.put(n.f.tag_del_post_id, oVar.getId());
                return;
            }
            sparseArray2.put(n.f.tag_should_delete_visible, false);
        }
    }
}
