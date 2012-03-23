package com.baidu.tieba.util;

import android.graphics.Bitmap;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes.dex */
public class SDRamImage {
    private static HashMap<String, Image> photo;
    private static HashMap<String, Image> pic;
    private int weight;

    public SDRamImage() {
        photo = new HashMap<>();
        pic = new HashMap<>();
        this.weight = 0;
    }

    public void addPhoto(String name, Bitmap bitmap) {
        synchronized (this) {
            try {
                this.weight++;
                if (photo.size() >= 100) {
                    deletePhoto();
                }
                Image image = new Image(this, null);
                image.image = bitmap;
                image.weight = Integer.valueOf(this.weight);
                photo.put(name, image);
            } catch (Exception ex) {
                TiebaLog.e(getClass().getName(), "addPhoto", ex.getMessage());
            }
        }
    }

    public void addPic(String name, Bitmap bitmap) {
        synchronized (this) {
            try {
                this.weight++;
                if (pic.size() >= 30) {
                    deletePic();
                }
                Image image = new Image(this, null);
                image.image = bitmap;
                image.weight = Integer.valueOf(this.weight);
                pic.put(name, image);
            } catch (Exception ex) {
                TiebaLog.e(getClass().getName(), "addPic", ex.getMessage());
            }
        }
    }

    private void deletePhoto() {
        synchronized (this) {
            String key = null;
            int tmp = 134217727;
            for (Map.Entry<String, Image> entry : photo.entrySet()) {
                if (entry.getValue().weight.intValue() < tmp) {
                    tmp = entry.getValue().weight.intValue();
                    key = entry.getKey();
                }
            }
            if (key != null) {
                photo.remove(key);
            } else {
                photo.clear();
            }
        }
    }

    public void deletePhoto(String key) {
        synchronized (this) {
            photo.remove(key);
        }
    }

    private void deletePic() {
        synchronized (this) {
            String key = null;
            int tmp = 134217727;
            for (Map.Entry<String, Image> entry : pic.entrySet()) {
                if (entry.getValue().weight.intValue() < tmp) {
                    tmp = entry.getValue().weight.intValue();
                    key = entry.getKey();
                }
            }
            if (key != null) {
                pic.remove(key);
            } else {
                pic.clear();
            }
        }
    }

    public Bitmap getPhoto(String name) {
        Bitmap bitmap;
        synchronized (this) {
            bitmap = null;
            Image image = photo.get(name);
            if (image != null) {
                this.weight++;
                bitmap = image.image;
                image.weight = Integer.valueOf(this.weight);
            }
        }
        return bitmap;
    }

    public Bitmap getPic(String name) {
        Bitmap bitmap;
        synchronized (this) {
            bitmap = null;
            Image image = pic.get(name);
            if (image != null) {
                this.weight++;
                bitmap = image.image;
                image.weight = Integer.valueOf(this.weight);
            }
        }
        return bitmap;
    }

    public void clearPicAndPhoto() {
        photo.clear();
        pic.clear();
    }

    public void LogCount() {
        int photo_size = photo.size();
        int i = 0;
        TiebaLog.log_e(0, getClass().getName(), "logPrint", "photo.size = " + String.valueOf(photo_size));
        for (Map.Entry<String, Image> entry : photo.entrySet()) {
            StringBuffer log = new StringBuffer(50);
            log.append("photo[");
            log.append(i);
            log.append("].width = ");
            log.append(entry.getValue().image.getWidth());
            log.append("\tphoto[");
            log.append(i);
            log.append("].height = ");
            log.append(entry.getValue().image.getHeight());
            TiebaLog.log_e(0, getClass().getName(), "logPrint", log.toString());
            i++;
        }
        int pic_size = pic.size();
        int i2 = 0;
        TiebaLog.log_e(0, getClass().getName(), "logPrint", "pic.size = " + String.valueOf(pic_size));
        for (Map.Entry<String, Image> entry2 : pic.entrySet()) {
            StringBuffer log2 = new StringBuffer(50);
            log2.append("pic[");
            log2.append(i2);
            log2.append("].width = ");
            log2.append(entry2.getValue().image.getWidth());
            log2.append("\tpic[");
            log2.append(i2);
            log2.append("].height = ");
            log2.append(entry2.getValue().image.getHeight());
            TiebaLog.log_e(0, getClass().getName(), "logPrint", log2.toString());
            i2++;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class Image {
        Bitmap image;
        Integer weight;

        private Image() {
        }

        /* synthetic */ Image(SDRamImage sDRamImage, Image image) {
            this();
        }
    }
}
