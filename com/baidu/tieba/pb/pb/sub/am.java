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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.widget.richText.TbRichTextView;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class am extends BaseAdapter {
    private com.baidu.tbadk.core.data.ah bfH;
    protected Context mContext;
    protected ArrayList<com.baidu.tieba.tbadkCore.data.r> YX = null;
    protected View.OnClickListener cUp = null;
    protected int cUq = 0;
    protected boolean cUr = false;
    protected boolean cJY = false;
    protected boolean aUl = false;
    private boolean mIsFromCDN = true;

    public am(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    public void setIsFromCDN(boolean z) {
        this.mIsFromCDN = z;
    }

    public int kT(String str) {
        if (this.YX == null) {
            return -1;
        }
        int size = this.YX.size();
        for (int i = 0; i < size; i++) {
            if (this.YX.get(i).getId().equals(str)) {
                return i;
            }
        }
        return -1;
    }

    public void h(com.baidu.tbadk.core.data.ah ahVar) {
        this.bfH = ahVar;
    }

    public void setDatas(ArrayList<com.baidu.tieba.tbadkCore.data.r> arrayList) {
        if (arrayList == null) {
            this.YX = new ArrayList<>();
        } else {
            this.YX = arrayList;
        }
    }

    public void J(View.OnClickListener onClickListener) {
        this.cUp = onClickListener;
    }

    public void t(int i, boolean z) {
        this.cUq = i;
        this.cUr = z;
    }

    public void fh(boolean z) {
        this.cJY = false;
    }

    public void setHasMoreData(boolean z) {
        this.aUl = z;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.YX == null) {
            return 0;
        }
        return this.YX.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.YX == null || i < 0 || i >= this.YX.size()) {
            return null;
        }
        return this.YX.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = ni();
        }
        a aVar = (a) ((SparseArray) view.getTag()).get(t.g.tag_holder);
        if (getItem(i) != null) {
            a(aVar, (com.baidu.tieba.tbadkCore.data.r) getItem(i), !(!this.aUl && i + 1 >= getCount()), i == 0);
        }
        return view;
    }

    /* loaded from: classes.dex */
    public class a {
        public View azA;
        public TbRichTextView cKi;
        public LinearLayout cUs;
        public TextView cUt;

        public a() {
        }
    }

    public View ni() {
        a aVar = new a();
        View inflate = LayoutInflater.from(this.mContext).inflate(t.h.new_sub_pb_list_item, (ViewGroup) null);
        aVar.azA = inflate;
        aVar.cUs = (LinearLayout) inflate.findViewById(t.g.sub_pb_item_columnlayout);
        aVar.cUt = (TextView) inflate.findViewById(t.g.manage_btn);
        aVar.cKi = (TbRichTextView) inflate.findViewById(t.g.new_sub_pb_list_richText);
        aVar.cKi.HC();
        aVar.cKi.setLineSpacing(1.0f);
        aVar.cKi.setTextSize(TbConfig.getContentSizeOfLzl(this.mContext));
        aVar.cKi.setTextColor(ar.getColor(t.d.gray_day_3));
        aVar.cUt.setOnClickListener(this.cUp);
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(t.g.tag_holder, aVar);
        inflate.setTag(sparseArray);
        return inflate;
    }

    public void a(a aVar, com.baidu.tieba.tbadkCore.data.r rVar, boolean z, boolean z2) {
        boolean z3;
        boolean z4;
        com.baidu.tbadk.widget.richText.c cVar;
        TextAppearanceSpan textAppearanceSpan;
        if (aVar != null && rVar != null) {
            aVar.cKi.setPadding(0, 0, 0, 0);
            int skinType = TbadkCoreApplication.m411getInst().getSkinType();
            if (rVar.getAuthor() != null) {
                String userName = rVar.getAuthor().getUserName();
                SparseArray sparseArray = (SparseArray) aVar.azA.getTag();
                if (sparseArray == null) {
                    sparseArray = new SparseArray();
                    aVar.azA.setTag(sparseArray);
                }
                sparseArray.put(t.g.tag_photo_username, userName);
                sparseArray.put(t.g.tag_clip_board, rVar);
                sparseArray.put(t.g.tag_is_subpb, true);
            }
            aVar.cKi.setLinkTextColor(ar.getColor(t.d.cp_link_tip_c));
            com.baidu.tbadk.widget.richText.a aiT = rVar.aiT();
            if (aiT != null) {
                ArrayList<com.baidu.tbadk.widget.richText.c> GS = aiT.GS();
                if (GS.size() > 0) {
                    com.baidu.tbadk.widget.richText.c cVar2 = GS.get(GS.size() - 1);
                    int type = cVar2.getType();
                    String str = "";
                    if (type == 1) {
                        String t = (GS.size() <= 1 || GS.get(GS.size() + (-2)).getType() == type) ? "  " + aw.t(rVar.getTime()) : aw.t(rVar.getTime());
                        SpannableStringBuilder GY = cVar2.GY();
                        if (aiT.aFb) {
                            GY.delete(GY.length() - aiT.aFc, GY.length());
                        }
                        str = aw.dw(t);
                        GY.append((CharSequence) str);
                        aiT.aFb = true;
                        aiT.aFc = str.length();
                        cVar = cVar2;
                    } else if (aiT.aFb) {
                        cVar = cVar2;
                    } else {
                        String t2 = aw.t(rVar.getTime());
                        com.baidu.tbadk.widget.richText.c cVar3 = new com.baidu.tbadk.widget.richText.c(1);
                        String dw = aw.dw(t2);
                        cVar3.append(dw);
                        aiT.aFb = true;
                        aiT.aFc = dw.length();
                        GS.add(cVar3);
                        cVar = cVar3;
                        str = dw;
                    }
                    if (skinType == 1) {
                        textAppearanceSpan = new TextAppearanceSpan(this.mContext, t.k.subtext_1);
                    } else {
                        textAppearanceSpan = new TextAppearanceSpan(this.mContext, t.k.subtext);
                    }
                    SpannableStringBuilder GY2 = cVar.GY();
                    GY2.setSpan(textAppearanceSpan, GY2.length() - str.length(), GY2.length(), 33);
                }
                aVar.cKi.setVoiceViewRes(t.h.voice_play_btn);
                aVar.cKi.setIsFromCDN(this.mIsFromCDN);
                aVar.cKi.setText(rVar.aiT());
            }
            boolean z5 = false;
            boolean z6 = false;
            boolean z7 = false;
            String userId = rVar.getAuthor().getUserId();
            if (this.cUq != 0) {
                z5 = true;
                z6 = true;
                if (userId != null && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                    z5 = false;
                }
                if (userId == null || userId.equals("0") || userId.length() == 0) {
                    z5 = false;
                }
            }
            if (!this.cUr) {
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
                aVar.cUt.setVisibility(0);
                aVar.cUt.setCompoundDrawablesWithIntrinsicBounds(ar.getDrawable(t.f.icon_floor_manage_n), (Drawable) null, (Drawable) null, (Drawable) null);
            } else if (z3) {
                aVar.cUt.setVisibility(0);
                aVar.cUt.setCompoundDrawablesWithIntrinsicBounds(ar.getDrawable(t.f.icon_pb_louzhonglou_gag), (Drawable) null, (Drawable) null, (Drawable) null);
            } else if (z4) {
                aVar.cUt.setVisibility(0);
                aVar.cUt.setCompoundDrawablesWithIntrinsicBounds(ar.getDrawable(t.f.icon_floor_delete_n), (Drawable) null, (Drawable) null, (Drawable) null);
            } else {
                aVar.cUt.setVisibility(8);
            }
            SparseArray sparseArray2 = (SparseArray) aVar.cUt.getTag();
            if (sparseArray2 == null) {
                sparseArray2 = new SparseArray();
                aVar.cUt.setTag(sparseArray2);
            }
            if (z5) {
                sparseArray2.put(t.g.tag_should_manage_visible, true);
                sparseArray2.put(t.g.tag_manage_user_identity, Integer.valueOf(this.cUq));
                sparseArray2.put(t.g.tag_forbid_user_name, rVar.getAuthor().getUserName());
                sparseArray2.put(t.g.tag_forbid_user_post_id, rVar.getId());
            } else {
                sparseArray2.put(t.g.tag_should_manage_visible, false);
            }
            if (z3) {
                if (this.bfH != null) {
                    sparseArray2.put(t.g.tag_user_mute_visible, true);
                    sparseArray2.put(t.g.tag_is_mem, Integer.valueOf(TbadkCoreApplication.getCurrentMemberType()));
                    if (rVar.getAuthor() != null) {
                        sparseArray2.put(t.g.tag_user_mute_mute_userid, rVar.getAuthor().getUserId());
                        sparseArray2.put(t.g.tag_user_mute_mute_username, rVar.getAuthor().getUserName());
                    }
                    if (this.bfH.getId() != null) {
                        sparseArray2.put(t.g.tag_user_mute_thread_id, this.bfH.getId());
                    }
                    sparseArray2.put(t.g.tag_user_mute_post_id, rVar.getId());
                }
            } else {
                sparseArray2.put(t.g.tag_user_mute_visible, false);
            }
            if (z4) {
                sparseArray2.put(t.g.tag_should_delete_visible, true);
                sparseArray2.put(t.g.tag_manage_user_identity, Integer.valueOf(this.cUq));
                sparseArray2.put(t.g.tag_del_post_is_self, Boolean.valueOf(z7));
                sparseArray2.put(t.g.tag_del_post_type, 2);
                sparseArray2.put(t.g.tag_del_post_id, rVar.getId());
                return;
            }
            sparseArray2.put(t.g.tag_should_delete_visible, false);
        }
    }
}
