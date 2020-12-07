package com.baidu.tieba.yuyinala.charm.charmrank;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.data.i;
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
/* loaded from: classes4.dex */
public class e extends BaseAdapter {
    private ArrayList<i.b> eOt = new ArrayList<>();
    private int gDD;
    private String mLiveId;
    private TbPageContext mPageContext;
    private String ohD;

    public e(TbPageContext tbPageContext, int i, String str, String str2) {
        this.mPageContext = tbPageContext;
        this.gDD = i;
        this.ohD = str;
        this.mLiveId = str2;
    }

    public void setData(List<i.b> list) {
        if (list != null) {
            this.eOt.clear();
            this.eOt.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        if (this.eOt == null) {
            return 0;
        }
        return this.eOt.size();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: Nm */
    public i.b getItem(int i) {
        if (this.eOt == null) {
            return null;
        }
        return this.eOt.get(i);
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public View getView(final int i, View view, ViewGroup viewGroup) {
        a aVar;
        final i.b item;
        if (view == null) {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(a.g.yuyin_sdk_charm_rank__list_item, viewGroup, false);
            a aVar2 = new a();
            aVar2.ojC = (CharmRankItemView) view.findViewById(a.f.item);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        if (aVar != null && getItem(i) != null && (item = getItem(i)) != null) {
            aVar.ojC.setData(i + 1, item);
            aVar.ojC.oiu.setData(item);
            aVar.ojC.setmCallBack(new CharmRankItemView.a() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.e.1
                @Override // com.baidu.tieba.yuyinala.charm.charmrank.CharmRankItemView.a
                public void ecQ() {
                    if (!TbadkCoreApplication.isLogin()) {
                        ViewHelper.skipToLoginActivity(e.this.mPageContext.getContext());
                        return;
                    }
                    com.baidu.live.personmanager.a aVar3 = new com.baidu.live.personmanager.a(e.this.mPageContext.getContext());
                    if (item.Fj()) {
                        aVar3.io(item.user_uk);
                        aVar3.b(new a.InterfaceC0203a() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.e.1.1
                            @Override // com.baidu.live.personmanager.a.InterfaceC0203a
                            public void Qu() {
                                item.follow_status = 0;
                                e.this.notifyDataSetChanged();
                                BdUtilHelper.showToast(e.this.mPageContext.getContext(), "已取消关注", 3000);
                            }

                            @Override // com.baidu.live.personmanager.a.InterfaceC0203a
                            public void t(int i2, String str) {
                            }
                        });
                    } else if (!item.Fj()) {
                        aVar3.s(item.user_uk, e.this.ohD, e.this.mLiveId);
                        aVar3.a(new a.InterfaceC0203a() { // from class: com.baidu.tieba.yuyinala.charm.charmrank.e.1.2
                            @Override // com.baidu.live.personmanager.a.InterfaceC0203a
                            public void Qu() {
                                e.this.Nn(i + 1);
                                item.follow_status = 1;
                                e.this.notifyDataSetChanged();
                                BdUtilHelper.showToast(e.this.mPageContext.getContext(), "关注成功", 3000);
                            }

                            @Override // com.baidu.live.personmanager.a.InterfaceC0203a
                            public void t(int i2, String str) {
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
    public void Nn(int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(UbcStatConstant.KEY_LIVE_TYPE, UbcStatConstant.VALUE_LIVE_TYPE_AUDIO);
            jSONObject.put(UbcStatConstant.KEY_CUSTOM_ROOM_ID, this.ohD);
            if (this.gDD == 0) {
                jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "contribtab");
                jSONObject.put("contrib_num", i);
            } else if (this.gDD == 1) {
                jSONObject.put(UbcStatConstant.KEY_CONTENT_EXT_SUBPAGE, "charmtab");
                jSONObject.put("charm_num", i);
            }
        } catch (JSONException e) {
            BdLog.e(e);
        }
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1395, "click", UbcStatConstant.Page.VOICE_ROOM, "follow").setContentExt(jSONObject));
    }

    /* loaded from: classes4.dex */
    private class a {
        private CharmRankItemView ojC;

        private a() {
        }
    }
}
