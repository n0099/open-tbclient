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
public class am extends BaseAdapter {
    private com.baidu.tbadk.core.data.z bdq;
    protected Context mContext;
    protected ArrayList<com.baidu.tieba.tbadkCore.data.r> YA = null;
    protected View.OnClickListener cLG = null;
    protected int cLH = 0;
    protected boolean cLI = false;
    protected boolean cDQ = false;
    protected boolean cLJ = false;
    private boolean mIsFromCDN = true;

    public am(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public int kM(String str) {
        if (this.YA == null) {
            return -1;
        }
        int size = this.YA.size();
        for (int i = 0; i < size; i++) {
            if (this.YA.get(i).getId().equals(str)) {
                return i;
            }
        }
        return -1;
    }

    public void g(com.baidu.tbadk.core.data.z zVar) {
        this.bdq = zVar;
    }

    public void setDatas(ArrayList<com.baidu.tieba.tbadkCore.data.r> arrayList) {
        if (arrayList == null) {
            this.YA = new ArrayList<>();
        } else {
            this.YA = arrayList;
        }
    }

    public void D(View.OnClickListener onClickListener) {
        this.cLG = onClickListener;
    }

    public void r(int i, boolean z) {
        this.cLH = i;
        this.cLI = z;
    }

    public void eU(boolean z) {
        this.cDQ = false;
    }

    public void setHasMoreData(boolean z) {
        this.cLJ = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.YA == null) {
            return 0;
        }
        return this.YA.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.YA == null || i < 0 || i >= this.YA.size()) {
            return null;
        }
        return this.YA.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = mT();
        }
        a aVar = (a) ((SparseArray) view.getTag()).get(n.g.tag_holder);
        if (getItem(i) != null) {
            a(aVar, (com.baidu.tieba.tbadkCore.data.r) getItem(i), !(!this.cLJ && i + 1 >= getCount()), i == 0);
        }
        return view;
    }

    /* loaded from: classes.dex */
    public class a {
        public TbRichTextView cDC;
        public LinearLayout cLK;
        public TextView cLL;
        public View rootView;

        public a() {
        }
    }

    public View mT() {
        a aVar = new a();
        View inflate = LayoutInflater.from(this.mContext).inflate(n.h.new_sub_pb_list_item, (ViewGroup) null);
        aVar.rootView = inflate;
        aVar.cLK = (LinearLayout) inflate.findViewById(n.g.sub_pb_item_columnlayout);
        aVar.cLL = (TextView) inflate.findViewById(n.g.manage_btn);
        aVar.cDC = (TbRichTextView) inflate.findViewById(n.g.new_sub_pb_list_richText);
        aVar.cDC.Gd();
        aVar.cDC.setLineSpacing(1.0f);
        aVar.cDC.setTextSize(TbConfig.getContentSizeOfLzl(this.mContext));
        aVar.cDC.setTextColor(as.getColor(n.d.gray_day_3));
        aVar.cLL.setOnClickListener(this.cLG);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(n.g.tag_holder, aVar);
        inflate.setTag(sparseArray);
        return inflate;
    }

    public void a(a aVar, com.baidu.tieba.tbadkCore.data.r rVar, boolean z, boolean z2) {
        boolean z3;
        boolean z4;
        com.baidu.tbadk.widget.richText.c cVar;
        TextAppearanceSpan textAppearanceSpan;
        if (aVar != null && rVar != null) {
            aVar.cDC.setPadding(0, 0, 0, 0);
            int skinType = TbadkCoreApplication.m411getInst().getSkinType();
            if (rVar.getAuthor() != null) {
                String userName = rVar.getAuthor().getUserName();
                SparseArray sparseArray = (SparseArray) aVar.rootView.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    aVar.rootView.setTag(sparseArray);
                }
                sparseArray.put(n.g.tag_photo_username, userName);
                sparseArray.put(n.g.tag_clip_board, rVar);
                sparseArray.put(n.g.tag_is_subpb, true);
            }
            aVar.cDC.setLinkTextColor(as.getColor(n.d.cp_link_tip_c));
            com.baidu.tbadk.widget.richText.a aFr = rVar.aFr();
            if (aFr != null) {
                ArrayList<com.baidu.tbadk.widget.richText.c> FA = aFr.FA();
                if (FA.size() > 0) {
                    com.baidu.tbadk.widget.richText.c cVar2 = FA.get(FA.size() - 1);
                    int type = cVar2.getType();
                    String str = "";
                    if (type == 1) {
                        String s = (FA.size() <= 1 || FA.get(FA.size() + (-2)).getType() == type) ? "  " + ax.s(rVar.getTime()) : ax.s(rVar.getTime());
                        SpannableStringBuilder FG = cVar2.FG();
                        if (aFr.aEl) {
                            FG.delete(FG.length() - aFr.aEm, FG.length());
                        }
                        str = ax.dz(s);
                        FG.append((CharSequence) str);
                        aFr.aEl = true;
                        aFr.aEm = str.length();
                        cVar = cVar2;
                    } else if (aFr.aEl) {
                        cVar = cVar2;
                    } else {
                        String s2 = ax.s(rVar.getTime());
                        com.baidu.tbadk.widget.richText.c cVar3 = new com.baidu.tbadk.widget.richText.c(1);
                        String dz = ax.dz(s2);
                        cVar3.append(dz);
                        aFr.aEl = true;
                        aFr.aEm = dz.length();
                        FA.add(cVar3);
                        cVar = cVar3;
                        str = dz;
                    }
                    if (skinType == 1) {
                        textAppearanceSpan = new TextAppearanceSpan(this.mContext, n.k.subtext_1);
                    } else {
                        textAppearanceSpan = new TextAppearanceSpan(this.mContext, n.k.subtext);
                    }
                    SpannableStringBuilder FG2 = cVar.FG();
                    FG2.setSpan(textAppearanceSpan, FG2.length() - str.length(), FG2.length(), 33);
                }
                aVar.cDC.setVoiceViewRes(n.h.voice_play_btn);
                aVar.cDC.setIsFromCDN(this.mIsFromCDN);
                aVar.cDC.setText(rVar.aFr());
            }
            boolean z5 = false;
            boolean z6 = false;
            boolean z7 = false;
            String userId = rVar.getAuthor().getUserId();
            if (this.cLH != 0) {
                z5 = true;
                z6 = true;
                if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z5 = false;
                }
                if (userId == null || userId.equals("0") || userId.length() == 0) {
                    z5 = false;
                }
            }
            if (!this.cLI) {
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
                aVar.cLL.setVisibility(0);
                aVar.cLL.setCompoundDrawablesWithIntrinsicBounds(as.getDrawable(n.f.icon_floor_manage_n), (Drawable) null, (Drawable) null, (Drawable) null);
            } else if (z3) {
                aVar.cLL.setVisibility(0);
                aVar.cLL.setCompoundDrawablesWithIntrinsicBounds(as.getDrawable(n.f.icon_pb_louzhonglou_gag), (Drawable) null, (Drawable) null, (Drawable) null);
            } else if (z4) {
                aVar.cLL.setVisibility(0);
                aVar.cLL.setCompoundDrawablesWithIntrinsicBounds(as.getDrawable(n.f.icon_floor_delete_n), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                aVar.cLL.setVisibility(8);
            }
            SparseArray sparseArray2 = (SparseArray) aVar.cLL.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                aVar.cLL.setTag(sparseArray2);
            }
            if (z5) {
                sparseArray2.put(n.g.tag_should_manage_visible, true);
                sparseArray2.put(n.g.tag_manage_user_identity, Integer.valueOf(this.cLH));
                sparseArray2.put(n.g.tag_forbid_user_name, rVar.getAuthor().getUserName());
                sparseArray2.put(n.g.tag_forbid_user_post_id, rVar.getId());
            } else {
                sparseArray2.put(n.g.tag_should_manage_visible, false);
            }
            if (z3) {
                if (this.bdq != null) {
                    sparseArray2.put(n.g.tag_user_mute_visible, true);
                    sparseArray2.put(n.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (rVar.getAuthor() != null) {
                        sparseArray2.put(n.g.tag_user_mute_mute_userid, rVar.getAuthor().getUserId());
                        sparseArray2.put(n.g.tag_user_mute_mute_username, rVar.getAuthor().getUserName());
                    }
                    if (this.bdq.getId() != null) {
                        sparseArray2.put(n.g.tag_user_mute_thread_id, this.bdq.getId());
                    }
                    sparseArray2.put(n.g.tag_user_mute_post_id, rVar.getId());
                }
            } else {
                sparseArray2.put(n.g.tag_user_mute_visible, false);
            }
            if (z4) {
                sparseArray2.put(n.g.tag_should_delete_visible, true);
                sparseArray2.put(n.g.tag_manage_user_identity, Integer.valueOf(this.cLH));
                sparseArray2.put(n.g.tag_del_post_is_self, Boolean.valueOf(z7));
                sparseArray2.put(n.g.tag_del_post_type, 2);
                sparseArray2.put(n.g.tag_del_post_id, rVar.getId());
                return;
            }
            sparseArray2.put(n.g.tag_should_delete_visible, false);
        }
    }
}
