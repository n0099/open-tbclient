package com.baidu.tieba.pb.pb.main;

import android.os.Parcelable;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.tbadkCore.data.AgreeData;
import com.baidu.tieba.tbadkCore.data.PostData;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class aj {
    private boolean hRg;
    private boolean hRi;
    private com.baidu.tieba.pb.data.d hRx;
    private String hUd;
    private boolean hUe;
    private boolean hUf;
    private Parcelable hUg;
    private boolean hUh;
    private PostData hUi;
    private PostData hUj;
    private int hUk;

    static {
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.pb.pb.main.aj.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.bUK().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.PB_RECORDER_RESET_CMD) { // from class: com.baidu.tieba.pb.pb.main.aj.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.bUK().reset();
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_LIKE_FORUM) { // from class: com.baidu.tieba.pb.pb.main.aj.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.bUK().a(1, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_UNLIKE_FORUM) { // from class: com.baidu.tieba.pb.pb.main.aj.4
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                aj.bUK().a(0, customResponsedMessage);
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_PENDANT) { // from class: com.baidu.tieba.pb.pb.main.aj.5
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tbadk.data.l)) {
                    aj.bUK().updateCurrentUserPendant((com.baidu.tbadk.data.l) customResponsedMessage.getData());
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016528) { // from class: com.baidu.tieba.pb.pb.main.aj.6
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    aj.bUK().b((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData());
                }
            }
        });
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016530) { // from class: com.baidu.tieba.pb.pb.main.aj.7
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof com.baidu.tieba.tbadkCore.data.e)) {
                    aj.bUK().a((com.baidu.tieba.tbadkCore.data.e) customResponsedMessage.getData());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a {
        private static aj hUl = new aj();
    }

    public static aj bUK() {
        return a.hUl;
    }

    private aj() {
        this.hUd = null;
        this.hUe = false;
        this.hRx = null;
        this.hUf = false;
        this.hUg = null;
        this.hRi = true;
        this.hRg = false;
        this.hUh = false;
    }

    public void ap(String str, boolean z) {
        this.hUe = false;
        if (z) {
            str = null;
        }
        if (str == null || str.length() < 1) {
            reset();
            this.hUd = null;
        } else if (!str.equals(this.hUd)) {
            reset();
            this.hUd = str;
        } else {
            this.hUe = true;
        }
    }

    public com.baidu.tieba.pb.data.d getPbData() {
        if (!this.hUe) {
            this.hUf = false;
            return null;
        } else if (this.hRx != null && this.hRx.bQB() != null && this.hRx.bQB().size() > 0) {
            this.hUf = true;
            com.baidu.tieba.pb.data.d dVar = this.hRx;
            this.hRx = null;
            return dVar;
        } else {
            this.hUf = false;
            this.hRx = null;
            return null;
        }
    }

    public Parcelable bUL() {
        if (this.hUf) {
            this.hUf = false;
            Parcelable parcelable = this.hUg;
            this.hUg = null;
            return parcelable;
        }
        this.hUg = null;
        return null;
    }

    public int bUM() {
        return this.hUk;
    }

    public void wN(int i) {
        this.hUk = i;
    }

    public PostData bUN() {
        return this.hUj;
    }

    public void k(PostData postData) {
        this.hUj = postData;
    }

    public PostData bUO() {
        return this.hUi;
    }

    public void l(PostData postData) {
        this.hUi = postData;
    }

    public boolean bTB() {
        return this.hRi;
    }

    public boolean bUP() {
        return this.hRg;
    }

    public boolean bUQ() {
        return this.hUh;
    }

    public boolean a(com.baidu.tieba.pb.data.d dVar, Parcelable parcelable, boolean z, boolean z2, boolean z3) {
        this.hUe = false;
        if (this.hUd == null) {
            reset();
            return false;
        } else if (dVar == null) {
            reset();
            return false;
        } else if (dVar.bQB() == null) {
            reset();
            return false;
        } else if (dVar.bQB().size() < 1) {
            reset();
            return false;
        } else if (parcelable == null) {
            reset();
            return false;
        } else {
            this.hRx = dVar;
            this.hUf = false;
            this.hUg = parcelable;
            this.hRi = z;
            this.hRg = z2;
            this.hUh = z3;
            return true;
        }
    }

    public void reset() {
        this.hUe = false;
        this.hRx = null;
        this.hUf = false;
        this.hUg = null;
    }

    public void a(int i, CustomResponsedMessage<?> customResponsedMessage) {
        if (customResponsedMessage != null && this.hRx != null && this.hRx.getForum() != null) {
            Object data = customResponsedMessage.getData();
            if ((data instanceof Long) && ((Long) data).longValue() == com.baidu.adp.lib.g.b.toLong(this.hRx.getForum().getId(), 0L)) {
                this.hRx.getForum().setLike(i);
            }
        }
    }

    public void updateCurrentUserPendant(com.baidu.tbadk.data.l lVar) {
        if (lVar != null && this.hRx != null && this.hRx.bQB() != null && this.hRx.bQB().size() > 0) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (!StringUtils.isNull(currentAccount)) {
                int size = this.hRx.bQB().size();
                for (int i = 0; i < size; i++) {
                    if (this.hRx.bQB().get(i) != null && this.hRx.bQB().get(i).aiG() != null && currentAccount.equals(this.hRx.bQB().get(i).aiG().getUserId()) && this.hRx.bQB().get(i).aiG().getPendantData() != null) {
                        this.hRx.bQB().get(i).aiG().getPendantData().mU(lVar.ahf());
                        this.hRx.bQB().get(i).aiG().getPendantData().ba(lVar.atE());
                    }
                }
            }
        }
    }

    public void a(com.baidu.tieba.tbadkCore.data.e eVar) {
        if (this.hRx != null && eVar != null) {
            ArrayList<PostData> bQB = this.hRx.bQB();
            if (!com.baidu.tbadk.core.util.v.isEmpty(bQB)) {
                AgreeData agreeData = eVar.agreeData;
                for (PostData postData : bQB) {
                    if (postData != null && TextUtils.equals(postData.getId(), agreeData.postId)) {
                        AgreeData akv = postData.akv();
                        akv.agreeType = agreeData.agreeType;
                        akv.hasAgree = agreeData.hasAgree;
                        akv.diffAgreeNum = agreeData.diffAgreeNum;
                        akv.agreeNum = agreeData.agreeNum;
                        akv.disAgreeNum = agreeData.disAgreeNum;
                        return;
                    }
                }
            }
        }
    }

    public void b(com.baidu.tieba.tbadkCore.data.e eVar) {
        if (this.hRx != null && this.hRx.bQz() != null && this.hRx.bQz().akv() != null && eVar != null) {
            AgreeData agreeData = eVar.agreeData;
            AgreeData akv = this.hRx.bQz().akv();
            if (!TextUtils.isEmpty(akv.threadId) && agreeData != null && !TextUtils.isEmpty(agreeData.threadId) && akv.threadId.equals(agreeData.threadId)) {
                akv.agreeType = agreeData.agreeType;
                akv.hasAgree = agreeData.hasAgree;
                akv.diffAgreeNum = agreeData.diffAgreeNum;
                akv.agreeNum = agreeData.agreeNum;
                akv.disAgreeNum = agreeData.disAgreeNum;
            }
        }
    }
}
