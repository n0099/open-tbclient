package com.baidu.tieba.write.b.a;

import android.content.Context;
import com.baidu.searchbox.publisher.controller.IPublisherManagerInterface;
import com.baidu.searchbox.publisher.controller.listener.SelectAtListener;
import com.baidu.searchbox.publisher.controller.listener.SelectTopicListener;
import com.baidu.searchbox.ugc.draft.DraftData;
import com.baidu.searchbox.ugc.draft.DraftUtils;
import com.baidu.searchbox.ugc.model.HttpRequestPublishModule;
import com.baidu.searchbox.ugc.provider.listener.OnVideoShareListener;
import com.baidu.searchbox.ugc.utils.UgcUBCUtils;
import com.baidu.searchbox.ugc.webjs.UgcSchemeModel;
/* loaded from: classes3.dex */
public final class d implements IPublisherManagerInterface {
    public static boolean GLOBAL_DEBUG = false;
    private static final String TAG = d.class.getSimpleName();
    private String npe = "baiduboxapp://v6/ugc/publish?upgrade=1&params=%7B%22icons%22%3A%5B%220%22%2C%224%22%2C%223%22%5D%2C%22source%22%3A%22ugc%22%2C%22source_from%22%3A%22userhome%22%2C%22url%22%3A%22%2Fsearchbox%3Faction%3Dugc%26cmd%3D177%26type%3Dbaijiahao%22%2C%22support_gif%22%3A1%2C%22topic_pageurl%22%3A%22baiduboxapp%3A%2F%2Fv1%2Feasybrowse%2Fopen%3Furl%3Dhttps%253A%252F%252Fmbd.baidu.com%252Fwebpage%253Ftype%253Dtopic%2526action%253Dsearch%26style%3D%257b%2522menumode%2522%253a%25222%2522%252c%2522showtoolbar%2522%253a%25221%2522%257d%26newbrowser%3D1%22%2C%22at_pageurl%22%3A%22baiduboxapp%3A%2F%2Fv1%2Feasybrowse%2Fopen%3Fnewbrowser%3D1%26style%3D%257B%2522menumode%2522%253A%25222%2522%252C%2522showtoolbar%2522%253A%25221%2522%257D%26url%3Dhttps%253A%252F%252Fmbd.baidu.com%252Fwebpage%253Ftype%253Dtopic%2526action%253Dat%26newbrowser%3D1%22%2C%22camera_buttons%22%3A%5B%22timer%22%2C%22speed%22%2C%22music%22%2C%22face%22%2C%22filter%22%2C%22sticker%22%5D%2C%22timer_count%22%3A%5B%223%22%2C%2210%22%5D%2C%22duration%22%3A%7B%22min%22%3A%223%22%2C%22max%22%3A%2220%22%7D%2C%22music_pageurl%22%3A%22https%3A%2F%2Fsv.baidu.com%2Ffeedvideoui%2Fview%2Fvideomusic%22%2C%22placeholder%22%3A%22%E5%88%86%E4%BA%AB%E6%96%B0%E9%B2%9C%E4%BA%8B%E2%80%A6%22%2C%22ugcCallback%22%3A%22profile_callback_dynamic_365%22%7D\n";
    private String npf = "baiduboxapp://v6/ugc/publish?upgrade=1&params=%7B%22icons%22%3A%5B%220%22%2C%224%22%2C%223%22%5D%2C%22source%22%3A%22ugc%22%2C%22source_from%22%3A%22userhome%22%2C%22url%22%3A%22%2Fsearchbox%3Faction%3Dugc%26cmd%3D177%26type%3Dbaijiahao%22%2C%22support_gif%22%3A1%2C%22topic_pageurl%22%3A%22baiduboxapp%3A%2F%2Fv1%2Feasybrowse%2Fopen%3Furl%3Dhttps%253A%252F%252Fmbd.baidu.com%252Fwebpage%253Ftype%253Dtopic%2526action%253Dsearch%26style%3D%257b%2522menumode%2522%253a%25222%2522%252c%2522showtoolbar%2522%253a%25221%2522%257d%26newbrowser%3D1%22%2C%22at_pageurl%22%3A%22baiduboxapp%3A%2F%2Fv1%2Feasybrowse%2Fopen%3Fnewbrowser%3D1%26style%3D%257B%2522menumode%2522%253A%25222%2522%252C%2522showtoolbar%2522%253A%25221%2522%257D%26url%3Dhttps%253A%252F%252Fmbd.baidu.com%252Fwebpage%253Ftype%253Dtopic%2526action%253Dat%26newbrowser%3D1%22%2C%22camera_buttons%22%3A%5B%22timer%22%2C%22speed%22%2C%22music%22%2C%22face%22%2C%22filter%22%2C%22sticker%22%5D%2C%22timer_count%22%3A%5B%223%22%2C%2210%22%5D%2C%22duration%22%3A%7B%22min%22%3A%223%22%2C%22max%22%3A%2220%22%7D%2C%22music_pageurl%22%3A%22https%3A%2F%2Fsv.baidu.com%2Ffeedvideoui%2Fview%2Fvideomusic%22%2C%22placeholder%22%3A%22%E5%88%86%E4%BA%AB%E6%96%B0%E9%B2%9C%E4%BA%8B%E2%80%A6%22%2C%22ugcCallback%22%3A%22profile_callback_dynamic_365%22%7D\n";
    private String npg = "baiduboxapp://v6/ugc/publish?upgrade=1&params=%7B%22icons%22%3A%5B%220%22%2C%224%22%2C%223%22%5D%2C%22source%22%3A%22ugc%22%2C%22source_from%22%3A%22userhome%22%2C%22url%22%3A%22%2Fsearchbox%3Faction%3Dugc%26cmd%3D177%26type%3Dbaijiahao%22%2C%22support_gif%22%3A1%2C%22topic_pageurl%22%3A%22baiduboxapp%3A%2F%2Fv1%2Feasybrowse%2Fopen%3Furl%3Dhttps%253A%252F%252Fmbd.baidu.com%252Fwebpage%253Ftype%253Dtopic%2526action%253Dsearch%26style%3D%257b%2522menumode%2522%253a%25222%2522%252c%2522showtoolbar%2522%253a%25221%2522%257d%26newbrowser%3D1%22%2C%22at_pageurl%22%3A%22baiduboxapp%3A%2F%2Fv1%2Feasybrowse%2Fopen%3Fnewbrowser%3D1%26style%3D%257B%2522menumode%2522%253A%25222%2522%252C%2522showtoolbar%2522%253A%25221%2522%257D%26url%3Dhttps%253A%252F%252Fmbd.baidu.com%252Fwebpage%253Ftype%253Dtopic%2526action%253Dat%26newbrowser%3D1%22%2C%22camera_buttons%22%3A%5B%22timer%22%2C%22speed%22%2C%22music%22%2C%22face%22%2C%22filter%22%2C%22sticker%22%5D%2C%22timer_count%22%3A%5B%223%22%2C%2210%22%5D%2C%22duration%22%3A%7B%22min%22%3A%223%22%2C%22max%22%3A%2220%22%7D%2C%22music_pageurl%22%3A%22https%3A%2F%2Fsv.baidu.com%2Ffeedvideoui%2Fview%2Fvideomusic%22%2C%22placeholder%22%3A%22%E5%88%86%E4%BA%AB%E6%96%B0%E9%B2%9C%E4%BA%8B%E2%80%A6%22%2C%22ugcCallback%22%3A%22profile_callback_dynamic_365%22%7D\n";

    @Override // com.baidu.searchbox.publisher.controller.IPublisherManagerInterface
    public void openPublisher(Context context, UgcSchemeModel ugcSchemeModel) {
        openPublisher(context, ugcSchemeModel, -1);
    }

    @Override // com.baidu.searchbox.publisher.controller.IPublisherManagerInterface
    public void openPublisher(Context context, UgcSchemeModel ugcSchemeModel, int i) {
    }

    @Override // com.baidu.searchbox.publisher.controller.IPublisherManagerInterface
    public void selectTopic(Context context, String str, SelectTopicListener selectTopicListener) {
    }

    @Override // com.baidu.searchbox.publisher.controller.IPublisherManagerInterface
    public void selectAt(Context context, String str, SelectAtListener selectAtListener) {
    }

    @Override // com.baidu.searchbox.publisher.controller.IPublisherManagerInterface
    public void saveDraft(String str, DraftData draftData) {
    }

    @Override // com.baidu.searchbox.publisher.controller.IPublisherManagerInterface
    public void deleteDraft(String str) {
        DraftUtils.deleteDraft(str);
    }

    @Override // com.baidu.searchbox.publisher.controller.IPublisherManagerInterface
    public DraftData getDraft(String str) {
        return DraftUtils.getDraft(str);
    }

    @Override // com.baidu.searchbox.publisher.controller.IPublisherManagerInterface
    public void setUbcConfig(UgcUBCUtils.UbcConfig ubcConfig) {
        UgcUBCUtils.setUbcConfig(ubcConfig);
    }

    @Override // com.baidu.searchbox.publisher.controller.IPublisherManagerInterface
    public void setDebug(boolean z) {
    }

    @Override // com.baidu.searchbox.publisher.controller.IPublisherManagerInterface
    public Class getTextImagePublishActivity() {
        return null;
    }

    @Override // com.baidu.searchbox.publisher.controller.IPublisherManagerInterface
    public Class getVideoPublishActivity() {
        return null;
    }

    @Override // com.baidu.searchbox.publisher.controller.IPublisherManagerInterface
    public Class getReplyPublishActivity() {
        return null;
    }

    @Override // com.baidu.searchbox.publisher.controller.IPublisherManagerInterface
    public void setOnVideoShareListener(OnVideoShareListener onVideoShareListener) {
    }

    @Override // com.baidu.searchbox.publisher.controller.IPublisherManagerInterface
    public OnVideoShareListener getOnVideoShareListener() {
        return null;
    }

    @Override // com.baidu.searchbox.publisher.controller.IPublisherManagerInterface
    public void setVideoUploadInfo(String str) {
        HttpRequestPublishModule.videoInfo = HttpRequestPublishModule.getVideoInfo(str);
    }
}
