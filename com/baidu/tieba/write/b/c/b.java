package com.baidu.tieba.write.b.c;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.searchbox.publisher.controller.listener.PublishRequestListener;
import com.baidu.searchbox.ugc.utils.UgcServerApiUtils;
import com.baidu.searchbox.upload.provider.UploadProviderManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.R;
import com.baidu.tieba.write.upload.ForwardUploadData;
import com.baidu.tieba.write.upload.ImageTextUploadData;
import com.baidu.tieba.write.upload.VideoUploadData;
/* loaded from: classes3.dex */
public final class b {
    private boolean isInit;
    private com.baidu.tieba.write.b.b.a nHJ;

    /* loaded from: classes3.dex */
    public interface a {
        void onFail(String str);

        void onSuccess(String str);
    }

    /* renamed from: com.baidu.tieba.write.b.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private static class C0875b {
        private static final b nHM = new b();
    }

    public static final b dTT() {
        return C0875b.nHM;
    }

    private b() {
        this.isInit = false;
        init();
    }

    public void init() {
        if (!this.isInit) {
            this.isInit = true;
            UgcServerApiUtils.setHostAddress(UgcServerApiUtils.ONLINE_HOST_ADRESS);
            UgcServerApiUtils.setPublisherUserAgent(UgcServerApiUtils.DEFAULT_PUBLISHER_USER_AGENT);
            com.baidu.d.b.a.uS().setAppName("tieba");
            if (this.nHJ == null) {
                this.nHJ = new com.baidu.tieba.write.b.b.a();
            }
            this.nHJ.yA(false);
            MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE) { // from class: com.baidu.tieba.write.b.c.b.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.adp.framework.listener.MessageListener
                public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                    if (customResponsedMessage != null && customResponsedMessage.getCmd() == 2005016 && b.this.nHJ != null) {
                        b.this.nHJ.yA(false);
                    }
                }
            });
        }
    }

    public void a(ImageTextUploadData imageTextUploadData, final a aVar) {
        if (imageTextUploadData == null) {
            if (aVar != null) {
                aVar.onFail(TbadkCoreApplication.getInst().getString(R.string.publish_dynamic_error));
                return;
            }
            return;
        }
        UploadProviderManager.getUploadProvider().imagesTextPublish(null, c.a(imageTextUploadData), imageTextUploadData.imagePaths, new PublishRequestListener() { // from class: com.baidu.tieba.write.b.c.b.2
            @Override // com.baidu.searchbox.publisher.controller.listener.PublishRequestListener
            public void onSuccess(String str) {
                if (aVar != null) {
                    aVar.onSuccess(str);
                }
            }

            @Override // com.baidu.searchbox.publisher.controller.listener.PublishRequestListener
            public void onFailed(String str) {
                if (aVar != null) {
                    aVar.onFail(str);
                }
            }
        });
    }

    public void a(ForwardUploadData forwardUploadData, final a aVar) {
        if (forwardUploadData == null) {
            if (aVar != null) {
                aVar.onFail(TbadkCoreApplication.getInst().getString(R.string.publish_dynamic_error));
                return;
            }
            return;
        }
        UploadProviderManager.getUploadProvider().publish(null, c.a(forwardUploadData), new PublishRequestListener() { // from class: com.baidu.tieba.write.b.c.b.3
            @Override // com.baidu.searchbox.publisher.controller.listener.PublishRequestListener
            public void onSuccess(String str) {
                if (aVar != null) {
                    aVar.onSuccess(str);
                }
            }

            @Override // com.baidu.searchbox.publisher.controller.listener.PublishRequestListener
            public void onFailed(String str) {
                if (aVar != null) {
                    aVar.onFail(str);
                }
            }
        });
    }

    public void a(VideoUploadData videoUploadData, final a aVar) {
        if (videoUploadData == null) {
            if (aVar != null) {
                aVar.onFail(TbadkCoreApplication.getInst().getString(R.string.publish_dynamic_error));
                return;
            }
            return;
        }
        UploadProviderManager.getUploadProvider().publish(null, c.a(videoUploadData), new PublishRequestListener() { // from class: com.baidu.tieba.write.b.c.b.4
            @Override // com.baidu.searchbox.publisher.controller.listener.PublishRequestListener
            public void onSuccess(String str) {
                if (aVar != null) {
                    aVar.onSuccess(str);
                }
            }

            @Override // com.baidu.searchbox.publisher.controller.listener.PublishRequestListener
            public void onFailed(String str) {
                if (aVar != null) {
                    aVar.onFail(str);
                }
            }
        });
    }
}
