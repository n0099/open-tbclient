package com.baidu.tieba.person;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tbadk.core.view.HeadImageView;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class bj extends BaseAdapter {
    private View.OnClickListener aLP;
    private ArrayList<UserData> amP;
    private View.OnClickListener bIb;
    private PersonListActivity bIt;
    boolean bIu;
    private View.OnClickListener bIv;
    private View.OnClickListener bIw;
    boolean bze;
    private int mSex;
    private boolean mHasMore = false;
    private boolean bHZ = false;
    boolean byz = false;

    public void WH() {
        this.byz = false;
        if (this.amP != null && this.amP.size() == 0) {
            this.byz = true;
        }
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }

    public void ei(boolean z) {
        this.bHZ = z;
    }

    public bj(PersonListActivity personListActivity, boolean z, boolean z2, int i, View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3, View.OnClickListener onClickListener4) {
        this.amP = null;
        this.bIt = null;
        this.bIu = false;
        this.bze = true;
        this.mSex = 0;
        this.bIb = null;
        this.aLP = null;
        this.bIv = null;
        this.bIw = null;
        this.bIt = personListActivity;
        this.bIu = z;
        this.bze = z2;
        this.mSex = i;
        this.bIb = onClickListener2;
        this.aLP = onClickListener3;
        this.bIv = onClickListener;
        this.bIw = onClickListener4;
        this.amP = new ArrayList<>();
    }

    public void L(ArrayList<UserData> arrayList) {
        this.amP.addAll(arrayList);
    }

    public void resetData() {
        this.amP.clear();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.byz) {
            return 1;
        }
        int i = 0;
        if (this.amP != null) {
            i = this.amP.size();
        }
        if (this.mHasMore) {
            return i + 1;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        if (this.amP == null || i >= this.amP.size()) {
            return null;
        }
        return this.amP.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        if (this.amP == null || i >= this.amP.size()) {
            return -1L;
        }
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        bk bkVar;
        View view2;
        if (this.amP != null) {
            if (view == null) {
                bk bkVar2 = new bk(this, null);
                if (getItemViewType(i) == 0) {
                    View inflate = com.baidu.adp.lib.g.b.ei().inflate(this.bIt.getPageContext().getPageActivity(), com.baidu.tieba.x.person_list_item, null);
                    bkVar2.bIx = (ViewGroup) inflate.findViewById(com.baidu.tieba.w.item_view);
                    bkVar2.bIx.setOnClickListener(this.bIv);
                    bkVar2.aCp = (HeadImageView) inflate.findViewById(com.baidu.tieba.w.photo);
                    bkVar2.aCp.setIsRound(false);
                    bkVar2.aCp.setAutoChangeStyle(true);
                    bkVar2.bId = (LinearLayout) inflate.findViewById(com.baidu.tieba.w.info);
                    bkVar2.aAq = (TextView) inflate.findViewById(com.baidu.tieba.w.name);
                    bkVar2.bIe = (TextView) inflate.findViewById(com.baidu.tieba.w.at_list_nodata);
                    bkVar2.ayW = (TextView) inflate.findViewById(com.baidu.tieba.w.intro);
                    bkVar2.bIc = (ImageView) inflate.findViewById(com.baidu.tieba.w.chat);
                    bkVar2.bIy = (TextView) inflate.findViewById(com.baidu.tieba.w.add);
                    bkVar2.bIc.setOnClickListener(this.bIb);
                    bkVar2.bIy.setOnClickListener(this.bIw);
                    bkVar2.mProgress = null;
                    view2 = inflate;
                } else {
                    View inflate2 = com.baidu.adp.lib.g.b.ei().inflate(this.bIt.getPageContext().getPageActivity(), com.baidu.tieba.x.new_pb_list_more, null);
                    bkVar2.aAq = (TextView) inflate2.findViewById(com.baidu.tieba.w.pb_more_text);
                    inflate2.setOnClickListener(this.aLP);
                    bkVar2.mProgress = (ProgressBar) inflate2.findViewById(com.baidu.tieba.w.progress);
                    view2 = inflate2;
                }
                view2.setTag(bkVar2);
                bkVar = bkVar2;
                view = view2;
            } else {
                bkVar = (bk) view.getTag();
            }
            if (getItemViewType(i) == 0) {
                if (this.byz) {
                    bkVar.bId.setVisibility(8);
                    bkVar.bIc.setVisibility(8);
                    bkVar.bIy.setVisibility(8);
                    bkVar.bIe.setVisibility(0);
                    if (this.bIu) {
                        if (this.bze) {
                            bkVar.bIe.setText(com.baidu.tieba.z.not_have_attention);
                        } else if (this.mSex == 2) {
                            bkVar.bIe.setText(com.baidu.tieba.z.her_no_attention_other);
                        } else if (this.mSex == 1) {
                            bkVar.bIe.setText(com.baidu.tieba.z.him_no_attention_other);
                        } else {
                            bkVar.bIe.setText(com.baidu.tieba.z.no_attention_other);
                        }
                    } else if (this.bze) {
                        bkVar.bIe.setText(com.baidu.tieba.z.not_have_fans);
                    } else if (this.mSex == 2) {
                        bkVar.bIe.setText(com.baidu.tieba.z.her_no_fan_other);
                    } else if (this.mSex == 1) {
                        bkVar.bIe.setText(com.baidu.tieba.z.him_no_fan_other);
                    } else {
                        bkVar.bIe.setText(com.baidu.tieba.z.no_fan_other);
                    }
                } else {
                    bkVar.bIx.setTag(Integer.valueOf(i));
                    bkVar.bIc.setVisibility(0);
                    bkVar.bIy.setVisibility(0);
                    bkVar.bId.setVisibility(0);
                    bkVar.bIe.setVisibility(8);
                    bkVar.aCp.d(this.amP.get(i).getPortrait(), 12, false);
                    bkVar.aAq.setText(this.amP.get(i).getName_show());
                    bkVar.ayW.setText(this.amP.get(i).getIntro());
                    bkVar.bIc.setTag(Integer.valueOf(i));
                    bkVar.bIy.setTag(Integer.valueOf(i));
                    String userId = this.amP.get(i).getUserId();
                    if (!TextUtils.isEmpty(userId) && userId.equals(TbadkCoreApplication.getCurrentAccount())) {
                        bkVar.bIc.setVisibility(8);
                        bkVar.bIy.setVisibility(8);
                    } else if (this.amP.get(i).getIsFriend() == 1) {
                        bkVar.bIc.setVisibility(0);
                        bkVar.bIy.setVisibility(8);
                    } else {
                        bkVar.bIc.setVisibility(8);
                        bkVar.bIy.setVisibility(0);
                    }
                }
                bkVar.mProgress = null;
            } else {
                bkVar.aAq.setText(this.bIt.getPageContext().getString(com.baidu.tieba.z.loading));
                bkVar.mProgress.setVisibility(0);
            }
            applyNightMode(view);
        }
        return view;
    }

    private void applyNightMode(View view) {
        this.bIt.getLayoutMode().ab(TbadkCoreApplication.m255getInst().getSkinType() == 1);
        this.bIt.getLayoutMode().h(view);
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getItemViewType(int i) {
        if (this.byz) {
            return 0;
        }
        return (this.amP == null || i >= this.amP.size()) ? 1 : 0;
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public int getViewTypeCount() {
        return 2;
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int i) {
        if (this.byz) {
            return false;
        }
        return super.isEnabled(i);
    }
}
