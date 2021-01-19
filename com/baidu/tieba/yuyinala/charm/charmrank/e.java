package com.baidu.tieba.yuyinala.charm.charmrank;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.j;
import com.baidu.live.personmanager.a;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.ubc.UbcStatConstant;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.tieba.yuyinala.charm.charmrank.CharmRankItemView;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class e extends BaseAdapter {
    private ArrayList<j.b> eTF = new ArrayList<>();
    private int gKL;
    private String mLiveId;
    private TbPageContext mPageContext;
    private String oeG;

    public e(TbPageContext tbPageContext, int i, String str, String str2) {
        this.mPageContext = tbPageContext;
        this.gKL = i;
        this.oeG = str;
        this.mLiveId = str2;
    }

    public void setData(List<j.b> list) {
        if (list != null) {
            this.eTF.clear();
            this.eTF.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eTF == null) {
            return 0;
        }
        return this.eTF.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Lq */
    public j.b getItem(int i) {
        if (this.eTF == null) {
            return null;
        }
        return this.eTF.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        final a aVar;
        final j.b item;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(a.g.yuyin_sdk_charm_rank__list_item, viewGroup, false);
            a aVar2 = new a();
            aVar2.ogM = (CharmRankItemView) view.findViewById(a.f.item);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        if (aVar != null && getItem(i) != null && (item = getItem(i)) != null) {
            if (aVar.ogM.getData() == null || !TextUtils.equals(aVar.ogM.getData().user_uk, item.user_uk)) {
                aVar.ogM.ofB.setData(item);
            }
            aVar.ogM.setData(i + 1, item);
            aVar.ogM.setmCallBack(new CharmRankItemView.a() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.e.1
                @Override // com.baidu.tieba.yuyinala.charm.charmrank.CharmRankItemView.a
                public void dXW() {
                    if (!TbadkCoreApplication.isLogin()) {
                        ViewHelper.skipToLoginActivity(e.this.mPageContext.getContext());
                        return;
                    }
                    com.baidu.live.personmanager.a aVar3 = new com.baidu.live.personmanager.a(e.this.mPageContext.getContext());
                    if (!item.AE()) {
                        aVar3.t(item.user_uk, e.this.oeG, e.this.mLiveId);
                        aVar3.a(new a.InterfaceC0192a() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.e.1.1
                            @Override // com.baidu.live.personmanager.a.InterfaceC0192a
                            public void ND() {
                                e.this.Lr(i + 1);
                                item.follow_status = 1;
                                aVar.ogM.aE(true, true);
                                BdUtilHelper.showToast(e.this.mPageContext.getContext(), "关注成功", 3000);
                            }

                            @Override // com.baidu.live.personmanager.a.InterfaceC0192a
                            public void w(int i2, String str) {
                            }
                        });
                    }
                }
            });
        }
        this.mPageContext.getLayoutMode().onModeChanged(view);
        return view;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Lr(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.oeG);
            if (this.gKL == 0) {
                jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "contribtab");
                jSONObject.put("contrib_num", i);
            } else if (this.gKL == 1) {
                jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "charmtab");
                jSONObject.put("charm_num", i);
            }
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", UbcStatConstant.Page.VOICE_ROOM, "follow").setContentExt(jSONObject));
    }

    /* loaded from: classes10.dex */
    private class a {
        private CharmRankItemView ogM;

        private a() {
        }
    }
}
