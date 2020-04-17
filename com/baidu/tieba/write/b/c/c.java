package com.baidu.tieba.write.b.c;

import android.text.TextUtils;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.searchbox.ugc.model.UgcConstant;
import com.baidu.searchbox.ugc.utils.UgcLoginUtils;
import com.baidu.tieba.write.upload.BaseUploadData;
import com.baidu.tieba.write.upload.ForwardUploadData;
import com.baidu.tieba.write.upload.ImageTextUploadData;
import com.baidu.tieba.write.upload.VideoUploadData;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class c {
    private static JSONObject b(BaseUploadData baseUploadData) {
        JSONObject jSONObject = new JSONObject();
        if (baseUploadData != null) {
            try {
                jSONObject.put(UgcConstant.SERVER_TOPICS_RULE, String.valueOf(0));
                jSONObject.put("content", baseUploadData.inputText);
                jSONObject.put("source_from", "tieba");
                jSONObject.put(UgcConstant.SOURCE_ID, "0");
                jSONObject.put(UgcConstant.SOURCE_TYPE, "0");
                JSONObject a = a(baseUploadData.poi);
                if (a != null) {
                    jSONObject.put("poi", a);
                }
                jSONObject.put("uk", UgcLoginUtils.getUK());
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return jSONObject;
    }

    public static JSONObject a(ImageTextUploadData imageTextUploadData) {
        return b(imageTextUploadData);
    }

    public static JSONObject a(ForwardUploadData forwardUploadData) {
        JSONObject b = b(forwardUploadData);
        try {
            JSONObject a = a(forwardUploadData.forward);
            if (a != null) {
                b.put("forward", a);
            }
            JSONObject a2 = a(forwardUploadData.extInfo);
            if (a2 != null) {
                b.put(UgcConstant.EXT_INFO, a2);
                return b;
            }
            return b;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static JSONObject a(VideoUploadData videoUploadData) {
        JSONObject b = b(videoUploadData);
        try {
            JSONArray a = a(videoUploadData.videos);
            if (a != null) {
                b.put("videos", a);
                return b;
            }
            return b;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static JSONObject a(BaseUploadData.Poi poi) {
        if (poi == null) {
            return null;
        }
        if (poi.qmUserPosition == null && poi.positionLatLng == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            if (poi.qmUserPosition != null) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("city", poi.qmUserPosition.city);
                jSONObject2.put("city-code", poi.qmUserPosition.city_code);
                jSONObject2.put("county", poi.qmUserPosition.county);
                jSONObject2.put("latitude", poi.qmUserPosition.latitude);
                jSONObject2.put("longitude", poi.qmUserPosition.longitude);
                jSONObject2.put("prov", poi.qmUserPosition.prov);
                jSONObject2.put("street", poi.qmUserPosition.street);
                jSONObject.put("qm_user_position", jSONObject2);
            }
            if (poi.positionLatLng != null) {
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("addr", poi.positionLatLng.addr);
                jSONObject3.put("city", poi.positionLatLng.city);
                jSONObject3.put("poi_type", poi.positionLatLng.poi_type);
                jSONObject3.put("city_id", poi.positionLatLng.city_id);
                jSONObject3.put("lat", poi.positionLatLng.lat);
                jSONObject3.put("lng", poi.positionLatLng.lng);
                jSONObject3.put("name", poi.positionLatLng.name);
                jSONObject3.put("pid", poi.positionLatLng.pid);
                jSONObject3.put("tag", poi.positionLatLng.tag);
                jSONObject.put("position_lat_lng", jSONObject3);
            }
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static JSONObject a(ForwardUploadData.Forward forward) {
        if (forward == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", forward.id);
            jSONObject.put("ref_type", forward.ref_type);
            jSONObject.put("account_type", forward.account_type);
            jSONObject.put("title", forward.title);
            jSONObject.put("url", forward.url);
            jSONObject.put("nid", forward.nid);
            jSONObject.put("thumbpic", forward.thumbpic);
            jSONObject.put("video_duration", forward.video_duration);
            jSONObject.put("pic_count", forward.pic_count);
            jSONObject.put("channel", forward.channel);
            jSONObject.put("tid", forward.tid);
            jSONObject.put(TableDefine.PaSubscribeColumns.COLUMN_AVATAR, forward.avatar);
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static JSONObject a(ForwardUploadData.ExtInfo extInfo) {
        if (extInfo == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("share_type", extInfo.share_type);
            jSONObject.put("forward_rel_id", extInfo.forward_rel_id);
            jSONObject.put("forward_is_comment", extInfo.forward_is_comment);
            jSONObject.put("forward_comment_thread_id", extInfo.forward_comment_thread_id);
            return jSONObject;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static JSONArray a(VideoUploadData.VideoInfo videoInfo) {
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject = new JSONObject();
        if (videoInfo != null && !TextUtils.isEmpty(videoInfo.mediaId)) {
            try {
                jSONObject.put("mediaId", videoInfo.mediaId);
                jSONObject.put("cover_img", videoInfo.coverUrl);
                jSONObject.put(TiebaInitialize.LogFields.SIZE, videoInfo.size);
                jSONObject.put("duration", videoInfo.duration);
                jSONObject.put("height_in_pixel", videoInfo.height);
                jSONObject.put("width_in_pixel", videoInfo.width);
                jSONObject.put("source_key", videoInfo.sourceKey);
                jSONObject.put("author_uk", videoInfo.authorUK);
                jSONObject.put("music_name", videoInfo.musicName);
                jSONObject.put("sound_src", videoInfo.soundSrc);
                jSONObject.put("bg_sound", videoInfo.bgSound);
                jSONObject.put("bg_sound_rec", videoInfo.bgSoundRec);
                jSONObject.put(UgcConstant.VIDEO_PRODUCTION_TYPE, videoInfo.videoProductionType);
                jSONObject.put("video_first_frame", videoInfo.videoFirstFrame);
                jSONArray.put(jSONObject);
                return jSONArray;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
